/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.controllers;

import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.be.User;
import attendance_recorder.be.Course;
import attendance_recorder.be.Date;
import attendance_recorder.bll.MockStudentManager;
import attendance_recorder.bll.utility.languages.LangDanish;
import attendance_recorder.gui.model.AppModel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author math2
 */
public class TeacherScreenFXMLController implements Initializable {

    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Course> courses;// = FXCollections.observableArrayList();    
    private AppModel am;
    private Teacher currentUser;
    private Date currentDate;
    private final ToggleGroup group = new ToggleGroup();

    
    @FXML
    private BorderPane diagramPane;
    @FXML
    private TableView<Student> tableStudents;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblAbsenceProcentage;
    @FXML
    private Label lblPresentStatus;
    @FXML
    private ImageView imageView;
    @FXML
    private ComboBox<Course> btnCourseSelect;
    @FXML
    private Label lblCurrentUser;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, Number> absenceColumn;
    @FXML
    private MenuBar menuBarTeacher;
    @FXML
    private Menu menubarTeacher;
    @FXML
    private MenuItem danishTgl;
    @FXML
    private MenuItem englishTgl;
    @FXML
    private Label firstNameLbl;
    @FXML
    private Label LastNameLbl;
    @FXML
    private Label absenceLbl;
    @FXML
    private Label statusLbl;
    @FXML
    private Label statisticsLbl;
  
    

    @FXML
    private RadioButton presentRadiobtn;
    @FXML
    private RadioButton absentRadioBtn;
    @FXML
    private TableView<Date> AbsenceTabel;
    @FXML
    private TableColumn<Date, String> dateColumn;
    @FXML
    private TableColumn<Date, Boolean> presensColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initColumns();
        
        currentUser = new Teacher(2, "jeppe", "led", "led", "jep");
        
        
        am = AppModel.getAppModel();
        
        courses = am.getTeachersCourse(currentUser);
        
        btnCourseSelect.setItems(courses);
        
        tableStudents.setItems(students);
        
        btnCourseSelect.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showStudentsInClass(currentUser));
        
        tableStudents.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                showIndividualStudentInformation(newValue);
                AbsenceTabel.getItems().clear();
                AbsenceTabel.setItems(getStudentDates(newValue));
                lblAbsenceProcentage.setText(am.getAbsencePercentage()+"%");
                diagramPane.setCenter(am.buildChart(newValue));
                
        });
        
        AbsenceTabel.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)-> currentDate = newValue);
        

        //Sets both radio buttons in the same group, making only 1 active at a time
        presentRadiobtn.setToggleGroup(group);
        absentRadioBtn.setToggleGroup(group);
        
      

    }
    
    private void initColumns()
    {
        nameColumn.setCellValueFactory(data -> {
            String name = data.getValue().getLastName() + ", " + data.getValue().getFirstName();
            return new SimpleStringProperty(name);
        });
        
        absenceColumn.setCellValueFactory(data -> {
            int absence = data.getValue().getAbsence();
            return new SimpleIntegerProperty(absence);
        });
        
        dateColumn.setCellValueFactory(data -> {
            String date = data.getValue().getDate();
            return new SimpleStringProperty(date);
        });
        
        presensColumn.setCellValueFactory(data -> {
            
            boolean absence = data.getValue().isIsPresent();
             return new SimpleBooleanProperty(absence);

        });
    }
    
    public void setCurrentUser(Teacher teacher)
    {
        currentUser = teacher;
        courses = FXCollections.observableArrayList(currentUser.getCourses());
        btnCourseSelect.setItems(courses); //is this really necessary?
        lblCurrentUser.setText("Logged in as: " + currentUser.getFirstName() + " " + currentUser.getLastName());
    }
    
    private void showStudentsInClass(Teacher t)
    {
        students = FXCollections.observableArrayList(am.getStudentsInCourse(t));
        tableStudents.getSelectionModel().clearSelection();
        tableStudents.setItems(students);  
        showIndividualStudentInformation(null);
    }
    
    private void showIndividualStudentInformation(Student student)
    {
        if (student != null) {
        lblFirstName.setText(student.getFirstName());
        lblLastName.setText(student.getLastName());
        lblAbsenceProcentage.setText(student.getAbsence() + "%");
        String presence = (student.isPresent()) ? "PRESENT" : "ABSENT";
        lblPresentStatus.setText(presence);
        imageView.setImage(new Image(student.getImageFilePath())); //perhaps student should just hold Image
    }
        else {
        lblFirstName.setText("");
        lblLastName.setText("");
        lblAbsenceProcentage.setText("");        
        lblPresentStatus.setText("");
        imageView.setImage(null);
        }
    }

    @FXML
    private void handleLogout(ActionEvent event)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/attendance_recorder/gui/views/LoginScreenFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage primStage = (Stage) menuBarTeacher.getScene().getWindow();
            Stage stage = new Stage();

            stage.setTitle("Attendance Login");
            stage.setScene(scene);
            stage.show();
            primStage.close();
        } catch (IOException ex)
        {
            Logger.getLogger(TeacherScreenFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleAbout(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information about license");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);        
        alert.setHeaderText(null);
        String content = String.format("%s%n%s%n%s", "Default user image is courtesy of Font Awesome by Dave Gandy.", "License: https://creativecommons.org/licenses/by-sa/3.0/deed.en", "No changes have been to the image.");
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleClose(ActionEvent event) {
    }

    @FXML
    private void handleDanishTrans(ActionEvent event) {

        LangDanish transDk = new LangDanish(LangDanish.Language.EN, LangDanish.Language.DK);
        
    danishTgl.setText(Arrays.toString(transDk.Translate(danishTgl.getText())));
    englishTgl.setText(Arrays.toString(transDk.Translate(englishTgl.getText())));
    firstNameLbl.setText("Fornavn");
    LastNameLbl.setText("Efternavn");
    absenceLbl.setText(Arrays.toString(transDk.Translate(absenceLbl.getText())));
    statusLbl.setText(Arrays.toString(transDk.Translate(statusLbl.getText())));
    statisticsLbl.setText(Arrays.toString(transDk.Translate(statisticsLbl.getText())));
    lblCurrentUser.setText("Logget ind som: " + currentUser.getFirstName() + " " + currentUser.getLastName());
    nameColumn.setText(Arrays.toString(transDk.Translate(nameColumn.getText())));
    absenceColumn.setText(Arrays.toString(transDk.Translate(absenceColumn.getText())));
    
    }

    @FXML
    private void handleEngTrans(ActionEvent event) {
    }

    @FXML
    private void HandleChangePresence(ActionEvent event) {
        
        LocalDate currentDate = LocalDate.parse(AbsenceTabel.getSelectionModel().getSelectedItem().getDate());
        int studentId = tableStudents.getSelectionModel().getSelectedItem().getId();
        boolean presence = true;
        
        if(presentRadiobtn.isSelected()){
            presence = true;
        }
        else if(absentRadioBtn.isSelected()){
            presence = false;
        }
        else{
            System.out.println("ikke valgt");
        }
        
        
        Date updatedDate = new Date(currentDate.toString(), studentId, presence);
        
        am.updatePresence(updatedDate);
        AbsenceTabel.getItems().clear();
        am.getStudentDates(tableStudents.getSelectionModel().getSelectedItem());
        diagramPane.setCenter(am.buildChart(tableStudents.getSelectionModel().getSelectedItem()));
        lblAbsenceProcentage.setText((am.getAbsencePercentage()+"%"));
        
        
    }
    
    private ObservableList<Date> getStudentDates(Student s){
        
        return am.getStudentDates(s);
        
        
    }
    
    
    
    
    
}

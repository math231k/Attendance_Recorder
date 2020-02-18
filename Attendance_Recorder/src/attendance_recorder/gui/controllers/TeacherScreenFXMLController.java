/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.controllers;

import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.be.User;
import attendance_recorder.be.Class;
import attendance_recorder.bll.MockStudentManager;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author math2
 */
public class TeacherScreenFXMLController implements Initializable {

    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Class> classes = FXCollections.observableArrayList();    
    private Teacher currentUser;
    
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
    private ComboBox<Class> btnClassSelect;
    @FXML
    private Label lblCurrentUser;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, Number> absenceColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initColumns();
        
        btnClassSelect.setItems(classes);
        tableStudents.setItems(students);
        
        btnClassSelect.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showStudentsInClass(newValue));
        
        tableStudents.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showIndvidualStudentInformation(newValue));
        
        buildPieChart();       
                
    }
    
    private void initColumns()
    {
        nameColumn.setCellValueFactory(data -> {
            String name = data.getValue().getFirstName() + " " + data.getValue().getLastName();
            return new SimpleStringProperty(name);
        });
        
        absenceColumn.setCellValueFactory(data -> {
            int absence = data.getValue().getAbsence();
            return new SimpleIntegerProperty(absence);
        });
    }
    
    public void setCurrentUser(Teacher teacher)
    {
        currentUser = teacher;
        classes = FXCollections.observableArrayList(teacher.getClasses());
        btnClassSelect.setItems(classes); //is this really necessary?
        lblCurrentUser.setText("Logged in as: " + teacher.getFirstName() + " " + teacher.getLastName());
    }
    
    private void showStudentsInClass(Class cl)
    {
        students = FXCollections.observableArrayList(cl.getStudents());
        tableStudents.setItems(students);        
    }
    
    private void showIndvidualStudentInformation(Student student)
    {
        lblFirstName.setText(student.getFirstName());
        lblLastName.setText(student.getLastName());
        lblAbsenceProcentage.setText(student.getAbsence() + "%");
        String presence = (student.isPresent()) ? "PRESENT" : "ABSENT";
        lblPresentStatus.setText(presence);
        imageView.setImage(new Image(student.getImageFilePath())); //perhaps student should just hold Image
    }
    
    
    private void buildPieChart(){
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Mondays", 3),
                new PieChart.Data("Tuesdays", 6),
                new PieChart.Data("wednesdays", 2),
                new PieChart.Data("Thursday", 5),
                new PieChart.Data("Fridays", 1)
                );
        
        PieChart pieChart = new PieChart(pieData);
        pieChart.setTitle("Student Absence");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);
        
        diagramPane.setCenter(pieChart);        
        
    }        
    
}

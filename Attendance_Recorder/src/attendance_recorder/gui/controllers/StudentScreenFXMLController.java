/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.controllers;

import attendance_recorder.be.Date;
import attendance_recorder.be.Student;
import attendance_recorder.bll.utility.languages.LangDanish;
import attendance_recorder.gui.model.AppModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author math2
 */
public class StudentScreenFXMLController implements Initializable {

    
    private Student currentUser;
    private Date selectedDate;
    private AppModel am;
    private final ToggleGroup group = new ToggleGroup();
    
    @FXML
    private Label lblWelcome;
    @FXML
    private AnchorPane studentPane;
    @FXML
    private BorderPane diagramPane;
    @FXML
    private ImageView imgLogo;
    @FXML
    private MenuBar menubarStudent;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblAbsence;
    @FXML
    private MenuItem menuItemDiagram;
    @FXML
    private MenuItem menuItemProfile;
    @FXML
    private JFXButton langEngBtn;
    @FXML
    private JFXButton langDanBtn;
    @FXML
    private JFXRadioButton radioAbsent;
    @FXML
    private JFXRadioButton radioPresent;
    @FXML
    private JFXButton btnSubmit;    
    @FXML
    private Label lblConnection;
    @FXML
    private JFXButton btnAbsenceNote;
    @FXML
    private JFXDatePicker JFXcalender;
    @FXML
    private TextArea txtAbsenceNote;
    @FXML
    private Label lblDatePresence;




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        am = AppModel.getAppModel();
        currentUser = am.getCurrentStudent();
        setCurrentUser(am.getCurrentStudent());
        
        
        imgLogo.setImage(getImage());
        menuItemDiagram.setDisable(false);
        menuItemProfile.setDisable(true);
        
        langDanBtn.setGraphic(new ImageView("/attendance_recorder/images/da.png"));
        langEngBtn.setGraphic(new ImageView("/attendance_recorder/images/en.png"));
        

        

        radioAbsent.setToggleGroup(group);
        radioPresent.setToggleGroup(group);
        
        
        
    }    
    
    public void setCurrentUser(Student student)
    {
        
        
        lblWelcome.setText(currentUser.getFirstName() + " " + currentUser.getLastName());
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy");
        lblDate.setText(localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + ", " + localDate.format(dateFormatter));
        lblAbsence.setText("Your total absence is " + am.getAbsencePercentage() + "%");
        
    }
   
    
    @FXML
    private void handleChart(ActionEvent event) {
    
       
        diagramPane.setCenter(am.buildChart(currentUser));
        
        menuItemProfile.setDisable(false);
    
    }

    @FXML
    private void handleMainView(ActionEvent event) {
       
        studentPane.setVisible(true);
        diagramPane.setCenter(studentPane);
        menuItemProfile.setDisable(true);
        menuItemDiagram.setDisable(false);
        
        
    }

    @FXML
    private void handleClose(ActionEvent event) {
    
   
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/attendance_recorder/gui/views/LoginScreenFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage primStage = (Stage) menubarStudent.getScene().getWindow();
            Stage stage = new Stage();

            stage.setTitle("Attendance Login");
            stage.setScene(scene);
            stage.show();
            primStage.close();
        } catch (IOException ex)
        {
            java.util.logging.Logger.getLogger(StudentScreenFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
    }
    
    private Image getImage(){
        Image logo = new Image("/attendance_recorder/images/EASVLogo.png");
        return logo;
    }

    @FXML
    private void handleDanTrans(ActionEvent event) {
        
        LangDanish transDk = new LangDanish(LangDanish.Language.EN, LangDanish.Language.DK);
        
        lblDate.setText(Arrays.toString(transDk.Translate(lblDate.getText())));
        lblAbsence.setText(Arrays.toString(transDk.Translate(lblAbsence.getText())));
        radioAbsent.setText(Arrays.toString(transDk.Translate(radioAbsent.getText())));
        radioPresent.setText(Arrays.toString(transDk.Translate(radioPresent.getText())));
        btnSubmit.setText(Arrays.toString(transDk.Translate(btnSubmit.getText())));        
        lblConnection.setText(Arrays.toString(transDk.Translate(lblConnection.getText())));
        
    }

    @FXML
    private void handleEngTrans(ActionEvent event) {
    }

    @FXML

    private void handleAbsence(ActionEvent event) {
        
        Date date = selectedDate;
        if (date == null) {
            showErrorAlert("Select a date.");
            return;
        }
        
        boolean presence = true;
        
        if(radioPresent.isSelected()){
            presence = true;
            txtAbsenceNote.clear();
        }
        else if(radioAbsent.isSelected()){
            presence = false;
        }
        else{
            showErrorAlert("Select Present or Absent");
        }
        
        date.setIsPresent(presence);
        am.updatePresence(selectedDate);
        am.getStudentDates(currentUser);
        
        
        setAbsenceLabelText();
        
        lblAbsence.setText((am.getAbsencePercentage()+"%"));
        
    }

    @FXML
    private void addEditAbsenceNote(ActionEvent event) {
        
        Date date = selectedDate;
        if (date==null) {
            showErrorAlert("Select a date.");
            return;
        }
        if (date.isIsPresent()==true) {
            showErrorAlert("You are/were present this day.");
            return;
        }
        date.setAbsenceNote(txtAbsenceNote.getText());
        am.updateAbsenceNote(date);
        //perhaps include confirmation option, update textarea, etc.
        
    }
    
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);        
        alert.setTitle("Error Dialog");
        alert.setHeaderText("ERROR");
        alert.setContentText(String.format(message));
        alert.showAndWait();
    }

    @FXML
    private void selectDate(ActionEvent event) {
        
        txtAbsenceNote.clear();
        lblDatePresence.setText("");
        selectedDate = new Date(JFXcalender.getValue().toString(), currentUser.getId(), true);
        
        List<Date> dates = am.getStudentDates(currentUser);
        for (Date date : dates) {
            if (JFXcalender.getValue().toString().equals(date.getDate())) {
                selectedDate = date;
                txtAbsenceNote.setText(selectedDate.getAbsenceNote());
                setAbsenceLabelText();
            }
        }
        
    }
    
    private void setAbsenceLabelText() {
        if (selectedDate.isIsPresent()==true) {
                    lblDatePresence.setText("PRESENT");
                    lblDatePresence.setTextFill(Color.GREEN);
                }
                else if (selectedDate.isIsPresent()==false) {
                    lblDatePresence.setText("ABSENT");
                    lblDatePresence.setTextFill(Color.RED);
                }
    }

    
}

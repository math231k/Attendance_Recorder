/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.controllers;

import attendance_recorder.be.Student;
import attendance_recorder.bll.MockStudentManager;
import attendance_recorder.bll.utility.languages.LangDanish;
import attendance_recorder.gui.model.AppModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author math2
 */
public class StudentScreenFXMLController implements Initializable {

    
    private Student currentUser;
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
    private TableColumn<?, ?> clmDate;
    private TableColumn<?, ?> clmPresence;
    @FXML
    private Label lblConnection;
    @FXML
    private JFXButton btnAbsenceNote;
    @FXML
    private JFXDatePicker JFXcalender;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        am = AppModel.getAppModel();
        
        imgLogo.setImage(getImage());
        menuItemDiagram.setDisable(false);
        menuItemProfile.setDisable(true);
        
        langDanBtn.setGraphic(new ImageView("/attendance_recorder/images/da.png"));
        langEngBtn.setGraphic(new ImageView("/attendance_recorder/images/en.png"));
        
        //radio buttons
        radioAbsent.setToggleGroup(group);
        radioPresent.setToggleGroup(group);
        
        
        
    }    
    
    public void setCurrentUser(Student student)
    {
        currentUser = student;
        
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
        clmDate.setText(Arrays.toString(transDk.Translate(clmDate.getText())));
        clmPresence.setText(Arrays.toString(transDk.Translate(clmPresence.getText())));
        lblConnection.setText(Arrays.toString(transDk.Translate(lblConnection.getText())));
        
    }

    @FXML
    private void handleEngTrans(ActionEvent event) {
    }

    @FXML
    private void addEditAbsenceNote(ActionEvent event) {
    }

    
}

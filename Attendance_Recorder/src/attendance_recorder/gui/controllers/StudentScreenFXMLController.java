/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.controllers;

import attendance_recorder.be.Student;
import attendance_recorder.bll.MockStudentManager;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
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
    
    @FXML
    private Label lblWelcome;
    @FXML
    private AnchorPane studentPane;
    @FXML
    private BorderPane diagramPane;
    @FXML
    private MenuBar menubarStudent;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void setCurrentUser(Student student)
    {
        currentUser = student;
        lblWelcome.setText("Good Morning " + student.getFirstName() + " " + student.getLastName());
    }

    @FXML
    private void handlePieChart(ActionEvent event) {
    
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Mondays", 3),
                new PieChart.Data("Tuesdays", 6),
                new PieChart.Data("Wednesdays", 2),
                new PieChart.Data("Thursday", 5),
                new PieChart.Data("Fridays", 1)
                );
        
        PieChart pieChart = new PieChart(pieData);
        pieChart.setTitle("Student Absence");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);
        
        studentPane.setVisible(false);
        
        diagramPane.setCenter(pieChart);
        
    
    }

    @FXML
    private void handleMainView(ActionEvent event) {
       
        studentPane.setVisible(true);
        diagramPane.setCenter(studentPane);
        
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
    
}

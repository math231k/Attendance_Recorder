/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.controllers;

import attendance_recorder.be.Student;
import attendance_recorder.bll.MockStudentManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author math2
 */
public class StudentScreenFXMLController implements Initializable {

    private MockStudentManager msm;
    private Student currentUser;
    
    @FXML
    private MenuItem handleClose; 
    @FXML
    private Label lblWelcome;
    @FXML
    private AnchorPane studentPane;
    @FXML
    private BorderPane diagramPane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msm = new MockStudentManager();
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
    
}

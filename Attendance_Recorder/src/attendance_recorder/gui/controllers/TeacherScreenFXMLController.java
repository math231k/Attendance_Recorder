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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author math2
 */
public class TeacherScreenFXMLController implements Initializable {

    private ObservableList<Student> students = FXCollections.observableArrayList();;
    private MockStudentManager msm;
    
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
    private ComboBox<?> btnClassSelect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msm = new MockStudentManager();
        
        buildPieChart();
        
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

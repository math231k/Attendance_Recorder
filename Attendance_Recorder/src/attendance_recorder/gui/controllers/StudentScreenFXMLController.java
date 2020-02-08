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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;

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
    private MenuItem handlePieChart;   
    @FXML
    private Label lblWelcome;


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
    
}

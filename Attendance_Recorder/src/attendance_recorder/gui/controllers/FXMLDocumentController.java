/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.controllers;

import attendance_recorder.be.Student;
import attendance_recorder.bll.MockStudentManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

/**
 *
 * @author math2
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private MockStudentManager msm;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleLogin(ActionEvent event)
    {
        if (validateName() && validatePassword())
        {
            openStudentScreen();
        }
        else errorAlert("Enter correct name and password");
    }
    
    private boolean validateName()
    {
        List<Student> students = msm.getStudents();
        String name = txtName.getText().trim();
                
        for (Student student : students)
        {
            if (student.getProfileName().equals(name))
            {
                return true;
            }
        }
        
        return false;        
    }
    
    private boolean validatePassword()
    {
        List<Student> students = msm.getStudents();
        String password = txtPassword.getText().trim();
        
        for (Student student : students)
        {
            if (student.getProfileName().equals(password))
            {
                return true;
            }
        }
        
        return false; 
    }
    
    private void errorAlert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);        
        alert.setTitle("Error Dialog");
        alert.setHeaderText("ERROR");
        alert.setContentText(String.format(message));
        alert.showAndWait();
    }
    
    private void openStudentScreen()
    {
        
    }
            
                
    
}

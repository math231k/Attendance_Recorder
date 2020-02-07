/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder;

import attendance_recorder.be.Student;
import attendance_recorder.bll.MockStudentManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author math2
 */
public class TeacherScreenFXMLController implements Initializable {

    private ObservableList<Student> students = FXCollections.observableArrayList();;
    private MockStudentManager msm;
    
    @FXML
    private AnchorPane diagramPane;
    @FXML
    private TableView<?> tableClasses;
    @FXML
    private TableView<Student> tableStudents;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msm = new MockStudentManager();
        
        students.addAll(msm.getStudents());
        
        tableStudents.setItems(students);
    }    
    
}

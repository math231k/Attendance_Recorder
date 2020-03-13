/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.controllers;

import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.be.User;
import attendance_recorder.bll.MockStudentManager;
import attendance_recorder.bll.utility.ILanguage;
import attendance_recorder.bll.utility.languages.LangDanish;
import attendance_recorder.bll.utility.languages.LangDanish.Language;
import attendance_recorder.bll.utility.languages.LangEnglish;
import attendance_recorder.gui.model.AppModel;
import com.jfoenix.controls.JFXButton;
import com.sun.java.accessibility.util.Translator;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author math2
 */
public class FXMLDocumentController implements Initializable {
    
    private AppModel model;

    @FXML
    private TextField txtName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;    
    @FXML
    private ImageView imageView;
    @FXML
    private Label titleLbl;
    @FXML
    private Menu optionsBar;
    @FXML
    private JFXButton transDanBtn;
    @FXML
    private Button transEngBtn;
    @FXML
    private AnchorPane mainPane;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        imageView.setImage(getImage());

        model = new AppModel();
        
        txtName.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                login();
            }
        });
        txtPassword.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                login();
            }
        });
        
        transDanBtn.setGraphic(new ImageView("/attendance_recorder/images/da.png"));
        transEngBtn.setGraphic(new ImageView("/attendance_recorder/images/en.png"));

    }    
    
    @FXML
    private void handleLogin(ActionEvent event)
    {
        login();
        
    }
    
    private void login() {
        String name = txtName.getText();
        String password = txtPassword.getText();
        
        if (name.isEmpty() || password.isEmpty()) {
            errorAlert("The input fields must be filled out");
        }
        else if (getVerifiedStudent(name, password)!=null) {
            openStudentScreen(getVerifiedStudent(name, password));
        }
        else if (getVerifiedTeacher(name, password)!=null) {
            openTeacherScreen(getVerifiedTeacher(name, password));
        }
        else errorAlert("Name or password incorrect");
        
        txtPassword.clear();
    }
    
    private Student getVerifiedStudent(String name, String password)
    {
        List<Student> students = model.getAllStudents();

        for (Student student : students) {
            if (student.getProfileName().equals(name) && student.getPassword().equals(password)) {
                return student;
            }
        }             
                             
        return null;      
    }
    
    private Teacher getVerifiedTeacher(String name, String password)
    {
        List<Teacher> teachers = model.getTeachers();

        for (Teacher teacher : teachers) {
            if (teacher.getProfileName().equals(name) && teacher.getPassword().equals(password)) {
                return teacher;
            }
        }                     
                             
        return null;
    }           
        
    private void errorAlert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);        
        alert.setTitle("Error Dialog");
        alert.setHeaderText("ERROR");
        alert.setContentText(String.format(message));
        alert.showAndWait();
    }
    
    private void openStudentScreen(Student student)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/attendance_recorder/gui/views/StudentScreenFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage primStage = (Stage) btnLogin.getScene().getWindow();
            Stage stage = new Stage();                       
                    stage.setMaxHeight(355);
                    stage.setMinHeight(355);
                    stage.setMaxWidth(488);
                    stage.setMinWidth(488);
            stage.setTitle("Student Overview");
            stage.setScene(scene);
            //stage.initModality(Modality.WINDOW_MODAL);
            //stage.initOwner(primStage);
            StudentScreenFXMLController controller = fxmlLoader.getController();
            controller.setCurrentUser(student);
            stage.show();
            primStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            
        
    }
    
    private void openTeacherScreen(Teacher teacher)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/attendance_recorder/gui/views/TeacherScreenFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage primStage = (Stage) btnLogin.getScene().getWindow();
            Stage stage = new Stage();                       
                    stage.setMaxHeight(500);
                    stage.setMinHeight(500);
                    stage.setMaxWidth(800);
                    stage.setMinWidth(800);
            stage.setTitle("Teacher Overview");
            stage.setScene(scene);
            //stage.initModality(Modality.WINDOW_MODAL);
            //stage.initOwner(primStage);
            TeacherScreenFXMLController controller = fxmlLoader.getController();
            controller.setCurrentUser(teacher);
            stage.show();
            primStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            
        
    }

    @FXML
    private void handeTeacher(ActionEvent event) {
        
    }

    @FXML
    private void handleStudent(ActionEvent event) {
    
    }
    
    private Image getImage(){
        Image logo = new Image("/attendance_recorder/images/EASVLogo.png");
        return logo;
    }

    @FXML

    private void handleTranslation(ActionEvent event) {
        final LangDanish transDk = new LangDanish(Language.EN, Language.DK);
        
        txtName.setPromptText(Arrays.toString(transDk.Translate(txtName.getPromptText())));
        txtPassword.setPromptText(Arrays.toString(transDk.Translate(txtPassword.getPromptText())));
        btnLogin.setText(Arrays.toString(transDk.Translate(btnLogin.getText())));
        titleLbl.setText(Arrays.toString(transDk.Translate(titleLbl.getText())));

    }

    @FXML
    private void handleClose(ActionEvent event) {
    }

    
}

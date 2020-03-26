
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author math2
 */
public class Attendance_Recorder extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/attendance_recorder/gui/views/LoginScreenFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("EASV Attendance");
        
        stage.setScene(scene);
        stage.show();
        /*
        stage.setMaxHeight(355);
        stage.setMinHeight(355);
        stage.setMaxWidth(488);
        stage.setMinWidth(488);
        
        /* resulutionen til teacher skærmen
        stage.setMaxHeight(500);
        stage.setMinHeight(500);
        stage.setMaxWidth(800);
        stage.setMinWidth(800);
        resulutionen til login skærmen*/
        
        stage.setMaxHeight(280);
        stage.setMinHeight(280);
        stage.setMaxWidth(450);
        stage.setMinWidth(450);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

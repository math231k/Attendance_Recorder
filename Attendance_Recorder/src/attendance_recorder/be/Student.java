/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.be;

/**
 *
 * @author math2
 */
public class Student extends User {
    private int absence;
    private String imageFilePath;
    
    public Student(String firstName, String lastName, String profileName, String password) {
        super(firstName, lastName, profileName, password);
    }
     
    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }    
                   
    
}

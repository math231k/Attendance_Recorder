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
public class Student {
    private String firstName;
    private String lastName;
    private String profileName;
    private int absence;
    private String password;
    private String imageView;
    private boolean increasedAccess;

    public Student(String firstName, String lastName, String profileName, String password, String imageView, boolean increasedAccess) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.profileName = profileName;
        this.imageView = imageView;
        this.increasedAccess = increasedAccess;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
    public String getImageView(){
        return imageView;
        
    }
    public void setImageView(String imageView){
        this.imageView = imageView;
    }

    public boolean isIncreasedAccess() {
        return increasedAccess;
    }

    public void setIncreasedAccess(boolean increasedAccess) {
        this.increasedAccess = increasedAccess;
    }
    
    
    
    
    
    
}

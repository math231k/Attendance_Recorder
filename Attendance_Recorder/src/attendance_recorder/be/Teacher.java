/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fauxtistic
 */
public class Teacher extends User {
    
    List<Class> classes;

    public Teacher(String firstName, String lastName, String profileName, String password) {
        super(firstName, lastName, profileName, password);
        classes = new ArrayList<Class>();
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
    
    
    
    
    
}

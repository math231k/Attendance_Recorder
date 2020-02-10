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
public class Class {

    private String name;
    List<Student> students;
    
    public Class(String name) {
        this.name = name;
        students = new ArrayList<Student>();
    }    

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    
        
}

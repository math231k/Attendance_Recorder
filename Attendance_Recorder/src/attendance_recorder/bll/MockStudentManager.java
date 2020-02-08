/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.bll;

import attendance_recorder.be.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author math2
 */
public class MockStudentManager {
    
    private List<Student> students;

    public MockStudentManager() {
        
        students = new ArrayList<Student>();
        //Student s1 = new Student("Mathias", "Birins", "math231k", "test", "C:\\Users\\jonas\\OneDrive\\Desktop\\Skole projekter\\Movie\\Attendance_Recorder");
        Student s1 = new Student("Mathias", "Birins", "math231k", "test", "noimage", false);
        Student s2 = new Student("Jeppe", "Moritz Led", "jle", "test", "noimage", true);
        s1.setAbsence(2);        
        
        students.add(s1);
        students.add(s2);
        
    }
    
    
    
    public List<Student> getStudents(){
                
        
        return students;
    }
    
    
}

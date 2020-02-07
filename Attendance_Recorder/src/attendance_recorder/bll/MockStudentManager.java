/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.bll;

import attendance_recorder.be.Student;
import java.util.List;

/**
 *
 * @author math2
 */
public class MockStudentManager {
    
    private List<Student> students;

    public MockStudentManager() {
        Student s1 = new Student("Mathias", "Birins", 2);
        Student s2 = new Student("Kenneth", "Christensen", 2);
        Student s4 = new Student("Tobias", "Hasen", 2);
    
        students.add(s1);
        students.add(s2);
        students.add(s4);
    }
    
    
    
    public List<Student> getStudents(){
        return students;
    }
    
    
}

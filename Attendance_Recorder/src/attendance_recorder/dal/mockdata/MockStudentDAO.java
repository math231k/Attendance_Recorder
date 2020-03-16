/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.dal.mockdata;

import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import java.util.ArrayList;
import java.util.List;
import attendance_recorder.dal.facades.IStudentDalFacade;

/**
 *
 * @author fauxtistic
 */
public class MockStudentDAO implements IStudentDalFacade {

    public MockStudentDAO() {
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();        
                
        Student s1 = new Student(0, "Mathias", "Birins", "math231k", "test");
        Student s2 = new Student(1, "Mock", "Student", "student", "password");
        Student s3 = new Student(2, "Peter", "Nielsen", "student2", "test");
        Student s4 = new Student(3, "Hans", "Sørensen", "student3", "test");
        Student s5 = new Student(4, "Kasper", "Davidsen", "student4", "test");
        
        s1.setImageFilePath("/attendance_recorder/images/thiasPic.jpg");
        s1.setAbsence(2);             
        s2.setAbsence(14);             
        s3.setAbsence(7);             
        s4.setAbsence(10);             
        s5.setAbsence(8);             
        
        students.add(s1);
        students.add(s4);
        students.add(s3);
        students.add(s2);
        students.add(s5);
        
        return students;
    }
    
    
    
}

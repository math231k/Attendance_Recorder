/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.dal.mockdata;

import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.dal.facades.StudentDalFacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fauxtistic
 */
public class MockStudentDAO implements StudentDalFacade {

    public MockStudentDAO() {
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();        
                
        Student s1 = new Student("Mathias", "Birins", "math231k", "test");
        Student s2 = new Student("Mock", "Student", "student", "password");
        Student s3 = new Student("Peter", "Nielsen", "student2", "test");
        Student s4 = new Student("Hans", "Sørensen", "student3", "test");
        Student s5 = new Student("Kasper", "Davidsen", "student4", "test");
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.bll;

import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.be.Class;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author math2
 */
public class MockStudentManager {
    
    private List<Student> students;
    private List<Teacher> teachers;

    public MockStudentManager() {
        
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
        //Student s1 = new Student("Mathias", "Birins", "math231k", "test", "C:\\Users\\jonas\\OneDrive\\Desktop\\Skole projekter\\Movie\\Attendance_Recorder");
        Student s1 = new Student("Mathias", "Birins", "math231k", "test");
        Teacher t1 = new Teacher("Jeppe", "Moritz Led", "jle", "test");
        Teacher t2 = new Teacher("Søren", "Spangsberg Jørgensen", "smsj", "test");
        s1.setAbsence(2);   
        
        students.add(s1);
        
        List<Class> classes = new ArrayList<Class>();
        Class cl = new Class("CS2019");
        classes.add(cl);
        cl.setStudents(students);
        t1.setClasses(classes);
        teachers.add(t1);
        teachers.add(t2);
        
    }
           
    public List<Student> getStudents(){
                        
        return students;
    }
    
    public List<Teacher> getTeachers() {
        return teachers;
    }
        
}

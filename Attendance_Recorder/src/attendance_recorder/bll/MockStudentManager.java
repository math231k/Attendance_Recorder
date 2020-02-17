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
        List<Student> students2 = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
        //Student s1 = new Student("Mathias", "Birins", "math231k", "test", "C:\\Users\\jonas\\OneDrive\\Desktop\\Skole projekter\\Movie\\Attendance_Recorder");
        Student s1 = new Student("Mathias", "Birins", "math231k", "test");
        Student s2 = new Student("Mock", "Student", "student", "password");
        Teacher t1 = new Teacher("Jeppe", "Moritz Led", "jle", "test");
        Teacher t2 = new Teacher("Søren", "Spangsberg Jørgensen", "smsj", "test");
        Teacher t3 = new Teacher("Mock", "Teacher", "teacher", "password");
        s1.setAbsence(2);             
        
        students.add(s1);
        students.add(s2);
        students2.add(s2);
        
        List<Class> classes = new ArrayList<Class>();
        Class c1 = new Class("CS2019");
        Class c2 = new Class ("Mock class");
        classes.add(c1);
        classes.add(c2);
        c1.setStudents(students);
        c2.setStudents(students2);
        t1.setClasses(classes);
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        
    }
           
    public List<Student> getStudents(){
                        
        return students;
    }
    
    public List<Teacher> getTeachers() {
        return teachers;
    }
        
}

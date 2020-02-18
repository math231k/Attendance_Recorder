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
        Student s2 = new Student("Mock", "Student", "student", "password");
        Student s3 = new Student("Peter", "Nielsen", "student2", "test");
        Student s4 = new Student("Hans", "Sørensen", "student3", "test");
        Student s5 = new Student("Kasper", "Davidsen", "student4", "test");
        Teacher t1 = new Teacher("Jeppe", "Moritz Led", "jle", "test");
        Teacher t2 = new Teacher("Søren", "Spangsberg Jørgensen", "smsj", "test");
        Teacher t3 = new Teacher("Mock", "Teacher", "teacher", "password");
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
        
        List<Student> c1Students = new ArrayList<Student>();
        List<Student> c2Students = new ArrayList<Student>();
        
        c1Students.add(s2);
        c1Students.add(s1);
        c1Students.add(s3);
        c2Students.add(s2);
        c2Students.add(s4);
        c2Students.add(s5);
        
        List<Class> classes = new ArrayList<Class>();
        Class c1 = new Class("CS2019");
        Class c2 = new Class ("Mock class");
        classes.add(c1);
        classes.add(c2);
        c1.setStudents(c1Students);
        c2.setStudents(c2Students);
        t1.setClasses(classes);
        t2.setClasses(classes);
        t3.setClasses(classes);
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        
    }
           
    public List<Student> getAllStudents(){
                        
        return students;
    }
    
    public List<Teacher> getTeachers() {
        return teachers;
    }
        
}

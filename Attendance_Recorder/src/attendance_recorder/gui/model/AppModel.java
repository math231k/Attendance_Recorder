/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.model;

import attendance_recorder.be.Course;
import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.bll.CourseBllManager;
import attendance_recorder.bll.MockStudentManager;
import attendance_recorder.bll.StudentBllManager;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Rizvan
 */
public class AppModel
{
    private static AppModel am;
    private CourseBllManager cbm;
    private StudentBllManager sbm;
    ObservableList<Course> courses;

    public AppModel() {
        sbm = new StudentBllManager();
        cbm = new CourseBllManager();
    }
    
    public static AppModel getAppModel(){
        if (am != null){
            return am;
        }
        else{
            am = new AppModel();
            return am;
        }
    }
    
    public List<Student> getAllStudents(){
                        
        return sbm.getAllStudents();
    }
    
    public List<Teacher> getTeachers() {
        return sbm.getTeachers();
    }

    public ObservableList<Course> getAllCourses() {
        
        courses.addAll(cbm.getAllCourses());
        return courses;
    }
    
    
}

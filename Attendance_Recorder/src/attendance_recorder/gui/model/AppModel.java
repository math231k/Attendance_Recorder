/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.model;

import attendance_recorder.be.Course;
import attendance_recorder.be.Date;
import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.bll.CourseBllManager;
import attendance_recorder.bll.DateBllManager;
import attendance_recorder.bll.MockStudentManager;
import attendance_recorder.bll.StudentBllManager;
import java.util.Collection;
import java.util.List;
import javafx.collections.FXCollections;
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
    private DateBllManager dm;
    private ObservableList<Course> courses = FXCollections.observableArrayList();
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Date> dates = FXCollections.observableArrayList();

    private AppModel() {
        sbm = new StudentBllManager();
        cbm = new CourseBllManager();
        dm = new DateBllManager();
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
    
    public ObservableList<Student> getAllStudents(){
        students.addAll(sbm.getAllStudents());
        return students;
    }
    
    public List<Teacher> getTeachers() {
        return sbm.getTeachers();
    }

    public ObservableList<Course> getAllCourses() {
        
        courses.addAll(cbm.getAllCourses());
        return courses;
    }
    
    public ObservableList<Course> getTeachersCourse(Teacher t){
        
        courses.removeAll();
        courses.addAll(cbm.getTeachersCourse(t));
        return courses;
    }
    
    public ObservableList<Student> getStudentsInCourse(Teacher t){
        students.removeAll();
        students.addAll(cbm.getStudentsInCourse(t));
        return students;
    }

    public List<Date> getDates(Student s) {
        return dm.getDates(s);
    }

    public void updatePresence(Date updatedDate) {
        dm.updatePresence(updatedDate);
    }

    public ObservableList<Date> getStudentDates(Student selectedItem) {
        
        dates.removeAll();
        dates.addAll(dm.getDates(selectedItem));
        return dates;
    }
    
    
}

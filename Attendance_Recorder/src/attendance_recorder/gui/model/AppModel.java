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
import attendance_recorder.be.User;
import attendance_recorder.bll.CourseBllManager;
import attendance_recorder.bll.DateBllManager;
import attendance_recorder.bll.StudentBllManager;
import attendance_recorder.bll.utility.AbsenceCalculator;
import attendance_recorder.bll.utility.TeacherBllManager;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Rizvan
 */
public class AppModel
{
    private static AppModel appModel_Instance;
    private CourseBllManager cbm;
    private StudentBllManager sbm;
    private TeacherBllManager tbm;
    private DateBllManager dm;
    private Student currentStudent;
    private Teacher currentTeacher;
    private ObservableList<Course> courses = FXCollections.observableArrayList();
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Date> dates = FXCollections.observableArrayList();

    private AppModel() {
        sbm = new StudentBllManager();
        cbm = new CourseBllManager();
        dm = new DateBllManager();
        tbm = new TeacherBllManager();
        currentStudent = null;
        currentTeacher = null;
    }
    
    public static AppModel getAppModel(){
        if (appModel_Instance == null){
            appModel_Instance = new AppModel();
        }
            return appModel_Instance;
    }
    
    public ObservableList<Student> getAllStudents(){
        students.addAll(sbm.getAllStudents());
        return students;
    }
    
    public List<Teacher> getTeachers() {
        return tbm.getTeachers();
    }

    public ObservableList<Course> getAllCourses() {
        
        courses.addAll(cbm.getAllCourses());
        return courses;
    }
    
    public ObservableList<Course> getTeachersCourse(Teacher t){        
        courses.clear();
        courses.addAll(cbm.getTeachersCourse(t));
        
        return courses;
    }
    
    public ObservableList<Student> getStudentsInCourse(Course course){
        students.clear();
        students.addAll(cbm.getStudentsInCourse(course));
        return students;
    }

    public List<Date> getDates(Student s) {
        return dm.getDates(s);
    }

    public void updatePresence(Date updatedDate) {
        dm.updatePresence(updatedDate);
    }
    
    public boolean updateAbsenceNote(Date updatedDate) {
        return dm.updateAbsenceNote(updatedDate);
    }

    public ObservableList<Date> getStudentDates(Student selectedItem) {
        
        dates.clear();
        dates.addAll(dm.getDates(selectedItem));
        return dates;
    }
    
    public BarChart buildChart(Student s){
                
        
        AbsenceCalculator ac = new AbsenceCalculator(getStudentDates(s));
        
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Weekday");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Presence");
        
        BarChart barChart = new BarChart(xAxis, yAxis);
        
        XYChart.Series data = new XYChart.Series();
        data.setName("Student presence by weekday");
        
        data.getData().add(new XYChart.Data("Monday", ac.getAbsentMondays()));
        data.getData().add(new XYChart.Data("Tuesday", ac.getAbsentTuedays()));
        data.getData().add(new XYChart.Data("Wednesday", ac.getAbsentWedesdays()));
        data.getData().add(new XYChart.Data("Thursday", ac.getAbsentThursdays()));
        data.getData().add(new XYChart.Data("Friday", ac.getAbsentFridays()));
        
        barChart.getData().add(data);
        barChart.setLegendVisible(false);
        
        return barChart;      
        
    } 
    
    
    
    public double getAbsencePercentage(){
        
        AbsenceCalculator ac = new AbsenceCalculator(dates);        
        return ac.calculateAbsencePercentage(dates);       
    }
    
    public void setCurrentStudent(Student student){
        currentStudent = student;
    }
    
    public Student getCurrentStudent(){
        return currentStudent;
    }
    
    public void setCurrentTeacher(Teacher teacher){
        currentTeacher = teacher;
    }
    
    public Teacher getCurrentTeacher(){
        return currentTeacher;
    }
    
    
    
    
}

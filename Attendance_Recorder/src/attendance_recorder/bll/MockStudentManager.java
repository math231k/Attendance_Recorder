/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.bll;

import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.be.Class;
import attendance_recorder.dal.facades.StudentDalFacade;
import attendance_recorder.dal.facades.TeacherDalFacade;
import attendance_recorder.dal.mockdata.MockStudentDAO;
import attendance_recorder.dal.mockdata.MockTeacherDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author math2
 */
public class MockStudentManager {
    
    private StudentDalFacade studentDAO;
    private TeacherDalFacade teacherDAO;

    public MockStudentManager() {
        
        studentDAO = new MockStudentDAO();
        teacherDAO = new MockTeacherDAO();                
    }
           
    public List<Student> getAllStudents(){
                        
        return studentDAO.getAllStudents();
    }
    
    public List<Teacher> getTeachers() {
        return teacherDAO.getTeachers();
    }
        
}

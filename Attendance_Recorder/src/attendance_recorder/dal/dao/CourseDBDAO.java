/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.dal.dao;

import attendance_recorder.be.Course;
import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.dal.dbaccess.DBSettings;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author math2
 */
public class CourseDBDAO {
    
    
    private DBSettings dbs;

    public CourseDBDAO() {
        try {
            dbs = new DBSettings();
        } catch (IOException e) {

        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList();
        return courses;
    }
    
    public List<Course> getTeacherCourses(Teacher teacher) {
        List<Course> courses = new ArrayList();
        try(Connection con = dbs.getConnection()) {
            String sql = "SELECT DISTINCT name FROM Course WHERE TeacherID = ?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, teacher.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Course course = new Course(name);
                courses.add(course);
            }
            
        } catch (SQLServerException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }   
    
    public List<Student> getCourseStudents(Course course) {
        List<Student> students = new ArrayList();
        try(Connection con = dbs.getConnection()) {
            String sql = "SELECT * FROM Course JOIN Student ON Course.StudentID = Student.ID"
                    + " WHERE Course.name = ?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, course.getName());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String firstName = rs.getString("Name");
                String lastName = rs.getString("LastName");
                String profileName = rs.getString("Username");                             
                String password = rs.getString("Password");
                String imageFilePath = rs.getString("ImageFilePath");

                Student student = new Student(id, firstName, lastName, profileName, password, imageFilePath);                
                
                students.add(student);
            }
            
        } catch (SQLServerException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }   
          
       
}

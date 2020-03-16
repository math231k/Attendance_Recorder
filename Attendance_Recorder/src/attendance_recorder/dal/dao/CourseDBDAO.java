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
import java.sql.SQLException;
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

    public List<Course> getAllCouses() {
        
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.bll;

import attendance_recorder.be.Course;
import attendance_recorder.be.Date;
import attendance_recorder.be.Student;
import attendance_recorder.dal.dao.CourseDBDAO;
import attendance_recorder.dal.dao.DateDBDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author math2
 */
public class DateBllManager {

    private DateDBDAO dm;

    public DateBllManager() {
    
        dm = new DateDBDAO();
    }
    
    
    
    public List<Date> getDates(Student s) {
        return dm.getStudentDays(s);
    }

    public void updatePresence(Date updatedDate) {
         
        dm.updatePresence(updatedDate);
    
    }
    
}

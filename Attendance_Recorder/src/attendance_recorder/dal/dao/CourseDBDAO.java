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
    
    
    public boolean addSongToPlaylist(Course c, Teacher t, Student s) {

        try (Connection con = dbs.getConnection()) {
            String sql = "INSERT INTO Course (Name, TeacherId, StudentId) VALUES (?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, c.getName());
            stmt.setInt(2, t.getId());
            stmt.setInt(3, s.getId);

            int updatedRows = stmt.executeUpdate();

            return updatedRows > 0;

        } catch (SQLServerException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

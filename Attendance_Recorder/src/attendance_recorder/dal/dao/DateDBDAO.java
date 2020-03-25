/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.dal.dao;

import attendance_recorder.be.Course;
import attendance_recorder.be.Date;
import attendance_recorder.be.Student;
import attendance_recorder.dal.dbaccess.DBSettings;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class DateDBDAO {
    
    private DBSettings dbs;

    public DateDBDAO() {
        try {
            dbs = new DBSettings();
            
        } catch (IOException e) {

        }
        
        
        
    }
    
    
    public List<Date> getStudentDays(Student s){
    List<Date> days = new ArrayList();
        try(Connection con = dbs.getConnection()) {
            String sql = "SELECT * FROM Date WHERE StudentID = ?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, s.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String date = rs.getString("date");
                
                int presenceCheck = rs.getInt("presence");
                boolean presence = true;
                    if(presenceCheck == 1){
                        presence = true;
                    }
                    else if (presenceCheck == 0) {
                        presence = false;
                    }
                    
                int studentId = rs.getInt("studentId");
                String absenceNote = rs.getString("AbsenceNote");
                
                Date day = new Date(date, studentId, presence);
                day.getAbsenceNote();
                days.add(day);
            }
            
        } catch (SQLServerException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return days;
    }
    
    public boolean updatePresence(Date d){
        int presence = 0;
        try (Connection con = dbs.getConnection()) {
            String sql = "UPDATE Date Set presence = ? WHERE StudentId = ? AND Date = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            
            
            if(d.isIsPresent()){
                presence = 1;
            }
            else if (!d.isIsPresent()) {
                presence = 0;
            }            
            
            pstmt.setInt(1, presence);
            pstmt.setInt(2, d.getStudentId());
            pstmt.setString(3, d.getDate());            
            
            int updatedRows = pstmt.executeUpdate();
            
            if(updatedRows > 0){
                return true;
            }
            
            
              
        } catch (SQLServerException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
    
    public boolean updateAbsenceNote(Date d){        
        try (Connection con = dbs.getConnection()) {
            String sql = "UPDATE Date SET AbsenceNote = ? WHERE StudentId = ? AND Date = ?";            
            PreparedStatement pstmt = con.prepareStatement(sql);            
            pstmt.setString(1, d.getAbsenceNote());
            pstmt.setInt(2, d.getStudentId());
            pstmt.setString(3, d.getDate());            
            
            int updatedRows = pstmt.executeUpdate();            
            if(updatedRows > 0){
                return true;
            }            
                          
        } catch (SQLServerException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
}

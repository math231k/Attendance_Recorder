/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.bll;

import attendance_recorder.be.Date;
import attendance_recorder.be.Student;
import attendance_recorder.dal.dao.DateDBDAO;
import java.util.List;

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
    
    public boolean updateAbsenceNote(Date updatedDate) {
        return dm.updateAbsenceNote(updatedDate);
    }
    
}

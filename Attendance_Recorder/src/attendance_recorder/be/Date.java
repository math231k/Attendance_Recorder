/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.be;

import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author math2
 */
public class Date {
    private String date;
    private List<LocalDate> dates;
    private int studentId;
    private boolean isPresent;

    public Date(String date, int studentId, boolean isPresent) {
        this.date = date;
        this.studentId = studentId;
        this.isPresent = isPresent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean isIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }
    
    public LocalDate convertToLocalDate(String dateToBeConverted){
       
        LocalDate ld = LocalDate.parse(dateToBeConverted);
        
        return ld;
    }

    @Override
    public String toString() {
        return "Date{" + "date=" + date + ", studentId=" + studentId + ", isPresent=" + isPresent + '}';
    }
      
}

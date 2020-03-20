/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.bll.utility;

import attendance_recorder.be.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author math2
 */
public class AbsenceCalculator {
    
    private static final String MONDAY = "monday";
    private static final String TUESDAY = "tuesday";
    private static final String WEDNESDAY = "wednesday";
    private static final String THURSDAY = "thursday";
    private static final String FRIDAY = "friday";
    private static final String SATURDAY = "saturday";
    private static final String SUNDAY = "sunday";
    
    private int mondays;
    private int tuesdays;
    private int wednesdays;
    private int thursdays;
    private int fridays;
    private int saturdays;
    private int sundays;

    public AbsenceCalculator(ObservableList<Date> dates) {
    
        dayCounter(dates);
        
    }
   
    
    
    
    
    public int getAbsentMondays(){
        
        return mondays;
    }
    
    public int getAbsentTuedays(){
        
        return tuesdays;
    }
    
    public int getAbsentWedesdays(){
       
        return wednesdays;
    }
    
    public int getAbsentThursdays(){
        
        return thursdays;
    }
    
    public int getAbsentFridays(){
        
        return fridays;
    }
    
    public int getAbsentSaturdays(){
        
        return saturdays;
    }
    
    public int getAbsentSundays(){
        
        return sundays;
    }
    
    public void dayCounter(List<Date> d){
        
        for (Date localDate : d) {
            
        
    
        if(LocalDate.parse(localDate.getDate()).getDayOfWeek().equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().MONDAY)){
            mondays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().TUESDAY)){
            tuesdays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().WEDNESDAY)){
            wednesdays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().THURSDAY)){
            thursdays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().FRIDAY)){
            fridays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().SATURDAY)){
            saturdays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().SUNDAY)){
            sundays++;
        }
        
        
        
        }
        
        
    }
  
    
}

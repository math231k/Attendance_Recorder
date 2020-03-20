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
    
    private double percentage;
    private double  totalAbsence;

    public AbsenceCalculator(ObservableList<Date> dates) {
    
        dayCounter(dates);
        //getTotalAbsence(dates);
        
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
            if(!localDate.isIsPresent())
                mondays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).getDayOfWeek().equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().TUESDAY)){
            if(!localDate.isIsPresent())
                tuesdays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).getDayOfWeek().equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().WEDNESDAY)){
            if(!localDate.isIsPresent())
                wednesdays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).getDayOfWeek().equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().THURSDAY)){
            if(!localDate.isIsPresent())
                thursdays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).getDayOfWeek().equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().FRIDAY)){
            if(!localDate.isIsPresent())
                fridays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).getDayOfWeek().equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().SATURDAY)){
            if(!localDate.isIsPresent())
                saturdays++;
        }
        
        if(LocalDate.parse(localDate.getDate()).getDayOfWeek().equals(LocalDate.parse(localDate.getDate()).getDayOfWeek().SUNDAY)){
            if(!localDate.isIsPresent())
                sundays++;
        }

    }     
    }
  
    public double calculateAbsencePercentage(List<Date> dates){
 
        return percentage = getTotalAbsence(dates)/dates.size()*100;        
    }
    
    public double getTotalAbsence(List<Date> dates){
        
        totalAbsence = 0;
        
        for (Date date : dates) {
            if (!date.isIsPresent()) {
                totalAbsence++;
            }
        }
        return totalAbsence;
    }
    
    
}

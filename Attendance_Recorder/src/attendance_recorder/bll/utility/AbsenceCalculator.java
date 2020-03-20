/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.bll.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public AbsenceCalculator(List<LocalDate> dates) {
    
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
    
    public void dayCounter(List<LocalDate> d){
        
        for (LocalDate localDate : d) {
            
        
    
        if(localDate.getDayOfWeek().equals(localDate.getDayOfWeek().MONDAY)){
            mondays++;
        }
        
        if(localDate.getDayOfWeek().equals(localDate.getDayOfWeek().TUESDAY)){
            tuesdays++;
        }
        
        if(localDate.getDayOfWeek().equals(localDate.getDayOfWeek().WEDNESDAY)){
            wednesdays++;
        }
        
        if(localDate.getDayOfWeek().equals(localDate.getDayOfWeek().THURSDAY)){
            thursdays++;
        }
        
        if(localDate.getDayOfWeek().equals(localDate.getDayOfWeek().FRIDAY)){
            fridays++;
        }
        
        if(localDate.getDayOfWeek().equals(localDate.getDayOfWeek().SATURDAY)){
            saturdays++;
        }
        
        if(localDate.getDayOfWeek().equals(localDate.getDayOfWeek().SUNDAY)){
            sundays++;
        }
        
        
        
        }
        
        
    }
    
        public static void main(String[] args) {
        
            
            
            List<LocalDate> dates = new ArrayList<>();
                    
            
            LocalDate ld1 = LocalDate.parse("2020-04-21");
            LocalDate ld2 = LocalDate.parse("2020-02-04");
            LocalDate ld3 = LocalDate.parse("2020-04-25");
            LocalDate ld4 = LocalDate.parse("2020-04-20");
            LocalDate ld5 = LocalDate.parse("2020-06-05");
            LocalDate ld6 = LocalDate.parse("2020-04-19");
            LocalDate ld7 = LocalDate.parse("2020-07-18");
            LocalDate ld8 = LocalDate.parse("2020-12-24");
            LocalDate ld9 = LocalDate.parse("2020-03-02");
            LocalDate ld10 = LocalDate.parse("2020-06-10");
            LocalDate ld11 = LocalDate.parse("2020-08-11");
            LocalDate ld12 = LocalDate.parse("2020-04-15");
            LocalDate ld13 = LocalDate.parse("2020-11-17");
            LocalDate ld14 = LocalDate.parse("2020-01-01");
            LocalDate ld15 = LocalDate.parse("2020-05-30");
            LocalDate ld16 = LocalDate.parse("2020-10-10");
            
            dates.add(ld1);
            dates.add(ld2);
            dates.add(ld3);
            dates.add(ld4);
            dates.add(ld5);
            dates.add(ld6);
            dates.add(ld7);
            dates.add(ld8);
            dates.add(ld9);
            dates.add(ld10);
            dates.add(ld11);
            dates.add(ld12);
            dates.add(ld13);
            dates.add(ld14);
            dates.add(ld15);
            dates.add(ld16);
            
            AbsenceCalculator ac = new AbsenceCalculator(dates);
            
            System.out.println(ac.getAbsentMondays()+ " Mondays");
            System.out.println(ac.getAbsentTuedays()+ " Tuesdays");
            System.out.println(ac.getAbsentWedesdays()+ " Wednesdays");
            System.out.println(ac.getAbsentThursdays()+ " Thursdays");
            System.out.println(ac.getAbsentFridays()+ " Fridays");
            System.out.println(ac.getAbsentSaturdays()+ " Saturdays");
            System.out.println(ac.getAbsentSundays()+ " Sundays");
    }
    
    
}

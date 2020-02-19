/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.dal.mockdata;

import attendance_recorder.be.Student;
import attendance_recorder.be.TempDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author math2
 */
public class MockDateManagerDAO {
    List<TempDate> datoer = new ArrayList<TempDate>();
    
    
    TempDate d1 = new TempDate("monday 3/2", "present");
    TempDate d2 = new TempDate("tuesday 4/2", "present");
    TempDate d3 = new TempDate("wednesday 5/2", "present");
    TempDate d4 = new TempDate("thursday 6/2", "present");
    TempDate d5 = new TempDate("friday 7/2", "present");
    TempDate d6 = new TempDate("monday 10/2", "present");
    TempDate d7 = new TempDate("tuesday 11/2", "present");
    
    public List<TempDate> getAllDates(){
        datoer.add(d1);
        datoer.add(d2);
        datoer.add(d3);
        datoer.add(d4);
        datoer.add(d5);
        datoer.add(d6);
        datoer.add(d7);
        
        return datoer;
    }
    
    
    
}

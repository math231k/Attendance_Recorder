/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.be;

/**
 *
 * @author math2
 */
public class TempDate {
    String date;
    String precence;

    public TempDate(String date, String precence) {
        this.date = date;
        this.precence = precence;
    }

    @Override
    public String toString() {
        return "TempDate{" + "date=" + date + ", precence=" + precence + '}';
    }
    
    
}

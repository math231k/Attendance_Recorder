/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance_recorder.gui.model;

import attendance_recorder.be.Student;
import attendance_recorder.be.Teacher;
import attendance_recorder.bll.MockStudentManager;
import java.util.List;

/**
 *
 * @author Rizvan
 */
public class AppModel
{
    
    private MockStudentManager msm;

    public AppModel() {
        msm = new MockStudentManager();
    }
    
    public List<Student> getAllStudents(){
                        
        return msm.getAllStudents();
    }
    
    public List<Teacher> getTeachers() {
        return msm.getTeachers();
    }
    
    
}

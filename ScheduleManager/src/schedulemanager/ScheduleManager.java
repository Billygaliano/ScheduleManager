/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulemanager;

import view.JF_Login;
import view.JF_ViewSchedule;

/**
 *
 * @author Guillermo Galiano
 */
public class ScheduleManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     java.awt.EventQueue.invokeLater(new Runnable() {
            
            JF_Login view= new JF_Login();
            //JF_ViewSchedule view= new JF_ViewSchedule();
            public void run() {
                view.setVisible(true);
            }
            
        });
    }
    
}

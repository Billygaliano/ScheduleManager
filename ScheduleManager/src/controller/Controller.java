package controller;

import model.Request;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import view.JF_ViewSchedule;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angie
 */
public class Controller implements ActionListener{
    JF_ViewSchedule vistaRequest = new JF_ViewSchedule();
    Request modeloRequest =new Request();
    ArrayList<Request> request = new ArrayList<>();
    String applicant="12345678A";
    
    public Controller(){
    }  
       

    public ArrayList<Request> getAllRequest(){
        ArrayList<Request> lista=modeloRequest.returnListRequest(applicant);
        
        return lista;
    }
    
    public String getSelectedRequest(int row){
       return modeloRequest.getSelectedMessage(row, applicant);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

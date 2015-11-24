package controller;

import model.Request;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import view.JF_ViewSchedule;
import javax.swing.table.DefaultTableModel;
import model.Titulation;

/**
 *
 * @author Angie
 */
public class Controller implements ActionListener{
    Request modeloRequest = new Request();
    Titulation titulationModel = new Titulation();
    String applicant="12345678A";
    
    public Controller(){
    }  
       

    public ArrayList<Request> getAllRequest(){
        ArrayList<Request> lista = modeloRequest.returnListRequest(applicant);
        return lista;
    }
    
    public String getSelectedRequest(int row){
       return modeloRequest.getSelectedMessage(row, applicant);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Titulation> getAllTitulations(){
        ArrayList<Titulation> titulationsList  = titulationModel.returnsTitulationList();
        return titulationsList;
    }
}

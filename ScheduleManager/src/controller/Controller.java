package controller;

import model.Request;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import view.JF_ViewSchedule;
import javax.swing.table.DefaultTableModel;
import model.Subject;
import model.Titulation;

/**
 *
 * @author Angie
 */
public class Controller implements ActionListener{
    Request modeloRequest = new Request();
    Titulation titulationModel = new Titulation();
    Subject subjectModel = new Subject();
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
        ArrayList<Titulation> titulationsList = titulationModel.returnsTitulationList();
        return titulationsList;
    }
    
    public ArrayList<Subject> getSubjectsTitulation(String titulation, String course, String quarter){
        ArrayList<Subject> subjectList = subjectModel.returnSubjectList(titulation, course, quarter);
        return subjectList;
    }
    
    public ArrayList<Titulation> getTitulationsAndSubjects() {
        ArrayList<Titulation> titulationsSubjectsList = titulationModel.returnsTitulationSubjectList(applicant);
        return titulationsSubjectsList;
    }
    
    public ArrayList<String> getCoursesTitulationUser(int id_titulation){
        ArrayList<String> courses = subjectModel.returnCoursesTitulationUser(applicant, id_titulation);
        return courses;
    }
    
    public ArrayList<String> getQuartersTitulationUser(int id_titulation, String course){
        ArrayList<String> quarters = subjectModel.returnQuartersTitulationUser(applicant, id_titulation, course);
        return quarters;
    }
}

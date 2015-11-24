package controller;

import model.Request;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import view.JF_ViewSchedule;
import javax.swing.table.DefaultTableModel;
import model.Schedule;
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
    Schedule scheduleModel = new Schedule();
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
    
    public ArrayList<String> getAvailableDays(){
        ArrayList<String> daysList = scheduleModel.returnDaysList();
        return daysList;
    }
    
    public ArrayList<String> getAvailableHours(String day){
        ArrayList<String> hourList = scheduleModel.returnHourList(day);
        return hourList;
    }
    
    public ArrayList<String> getAvailableClassroom(String day,String hour){
        ArrayList<String> classList = scheduleModel.returnClassList(day,hour);
        return classList;
    }
    
    public void setSchedule(String titulation,String course,String quarter,String subject,String day,String hour,String classroom){
        scheduleModel.insertSchedule(titulation,course,quarter,subject,day,hour,classroom);

    }
}

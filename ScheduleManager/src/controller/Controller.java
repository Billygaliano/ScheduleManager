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
    
    public ArrayList<Request> getAllAdminRequest(){
        ArrayList<Request> lista = modeloRequest.returnListRequest1();
        return lista;
    }
    
    public void SetAdminRequest(int fila,String status){
        modeloRequest.SetAdminRequest(fila,status);
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
    
    public ArrayList<String> getAvailableClassroom(String day,String hour,String subject){
        ArrayList<String> classList = scheduleModel.returnClassList(day,hour,subject);
        return classList;
    }
    
    public void setSchedule(String titulation,String course,String quarter,String subject,String day,String hour,String classroom,String year){
        scheduleModel.insertSchedule(titulation,course,quarter,subject,day,hour,classroom,year);

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
    
    public boolean setRequest(String subject, String text){
        boolean ok;
        ok = modeloRequest.setRequest(applicant, subject, text);
        return ok;
    }
    
    public ArrayList<String> getAllYears(){
       ArrayList<String> years = subjectModel.returnYearsSubjectUser(applicant);
       return years;
    }
    
    public ArrayList<String> getOccupiedDays(String subject){
        ArrayList<String> days = scheduleModel.returnOcuppiedDays(subject);
        return days;
    }
    
    public ArrayList<String> getOccupiedHours(String subject,String day){
        ArrayList<String> hours = scheduleModel.returnOcuppiedHours(subject,day);
        return hours;
    }
    
    public ArrayList<String> getOcuppiedClassroom(String day,String hour,String subject){
        ArrayList<String> classroom = scheduleModel.returnOcuppiedClassroom(day,hour,subject);
        return classroom;
    }
}

package controller;

import model.Request;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import view.JF_ViewSchedule;
import javax.swing.table.DefaultTableModel;
import model.Classroom;
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
    Classroom classroomModel = new Classroom();
    
    public Controller(){
    }         

    public ArrayList<Request> getAllRequest(String applicant){
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
       return modeloRequest.getSelectedMessage(row);
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
    
    public ArrayList<String> getAvailableDays(String quarter){
        ArrayList<String> daysList = scheduleModel.returnDaysList(quarter);
        return daysList;
    }
    
    public ArrayList<String> getAvailableHours(String day,String quarter){
        ArrayList<String> hourList = scheduleModel.returnHourList(day,quarter);
        return hourList;
    }
    
    public ArrayList<String> getAvailableClassroom(String day,String hour,String subject,String quarter){
        ArrayList<String> classList = scheduleModel.returnClassList(day,hour,subject,quarter);
        return classList;
    }
    
    public void setSchedule(String titulation,String course,String quarter,String subject,String day,String hour,String classroom,String year){
        scheduleModel.insertSchedule(titulation,course,quarter,subject,day,hour,classroom,year);

    }

    public ArrayList<Titulation> getTitulationsAndSubjects(String applicant) {
        ArrayList<Titulation> titulationsSubjectsList = titulationModel.returnsTitulationSubjectList(applicant);
        return titulationsSubjectsList;
    }
    
    public ArrayList<String> getCoursesTitulationUser(String applicant, int id_titulation){
        ArrayList<String> courses = subjectModel.returnCoursesTitulationUser(applicant, id_titulation);
        return courses;
    }
    
    public ArrayList<String> getQuartersTitulationUser(String applicant, int id_titulation, String course){
        ArrayList<String> quarters = subjectModel.returnQuartersTitulationUser(applicant, id_titulation, course);
        return quarters;
    }
    
    public boolean setRequest(String applicant,String subject, String text){
        boolean ok;
        ok = modeloRequest.setRequest(applicant, subject, text);
        return ok;
    }
    
    public ArrayList<String> getAllYears(String applicant){
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
    
    public void loadSchedule(JTable jTableSchedule, String quarter, String course, String titulation){
        ArrayList<Schedule> schedules = scheduleModel.returnSchedules(quarter, course, titulation);
        String title[] = {"Día", "Hora", "Asignatura", "Edificio", "Aula"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[5];
        String hour;
        
        for (Schedule schedule : schedules) {
            int idSubject = schedule.getSubject();
            int idClassroom = schedule.getClassroom();
            String subjectName = subjectModel.returnSubjectById(idSubject);
            Classroom classroom = classroomModel.returnClassroomById(idClassroom);
            String day = schedule.getDay();
            row[0] = schedule.getDay();
            row[1] = schedule.getHour();
            row[2] = subjectName;
            row[3] = classroom.getBuilding();
            row[4] = classroom.getName();
            
            m.addRow(row); 
        }
        
        jTableSchedule.setModel(m);
    }
    
    public int updateSchedule(String day_old,String hour_old,String classroom_old,String day_new,String hour_new,String classroom_new,String quarter){
        int  update = scheduleModel.updateSchedule(day_old,hour_old,classroom_old,day_new,hour_new,classroom_new,quarter);
        return update;
    
    }
    
    public ArrayList<Schedule> getSchedules(String quarter, String course, String titulation){
        ArrayList<Schedule> schedules = scheduleModel.returnSchedules(quarter, course, titulation);
        return schedules;
    }    
    
    public String getSubjectById(int idSubject){
        String subjectName = subjectModel.returnSubjectById(idSubject);
        return subjectName;
    }    
    
    public Classroom getClassroomById(int idClassroom){
        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
        return classroom;
    }
}

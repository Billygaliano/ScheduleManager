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
    String applicant="12345678A";
    
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
    
    public String getSelectedRequest(int row,String applicant){
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
        String title[] = {"Hora/Día", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        DefaultTableModel m = new DefaultTableModel(null,title);
        String row[] = new String[6];
        String hour;
            
        for (int i = 0; i <= 12; i++) {
            switch(i){
                case 0:{
                    row[0] = "8:30-9:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 1:{
                    row[0] = "9:30-10:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 2:{
                    row[0] = "10:30-11:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 3:{
                    row[0] = "11:30-12:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 4:{
                    row[0] = "12:30-13:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 5:{
                    row[0] = "13:30-14:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 6:{
                    row[0] = "14:30-15:30";
                    row[1] = "ES";
                    row[2] = "LA";
                    row[3] = "HORA";
                    row[4] = "DEL";
                    row[5] = "ALMUERZO";
                }break;

                case 7:{
                    row[0] = "15:30-16:30";
                    row[1] = "";
                    row[2] = "";
                    row[3] = "";
                    row[4] = "";
                    row[5] = "";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 8:{
                    row[0] = "16:30-17:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 9:{
                    row[0] = "17:30-18:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 10:{
                    row[0] = "18:30-19:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 11:{
                    row[0] = "19:30-20:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

                case 12:{
                    row[0] = "20:30-21:30";
                    
                    for (Schedule schedule : schedules){ 
                        int idSubject = schedule.getSubject();
                        int idClassroom = schedule.getClassroom();
                        String subjectName = subjectModel.returnSubjectById(idSubject);
                        Classroom classroom = classroomModel.returnClassroomById(idClassroom);
                        String day = schedule.getDay();

                        switch(day){
                            case "Lunes":{
                                row[1] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Martes":{
                                row[2] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Miercoles":{
                                row[3] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Jueves":{
                                row[4] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;

                            case "Viernes":{
                                row[5] = subjectName + " \n " + classroom.getBuilding() + " - " + classroom.getName();
                            }break;
                        }
                    }
                }break;

            }
            
            m.addRow(row);   
        } 
        
        jTableSchedule.setModel(m);
    }
    
    public int updateSchedule(String day_old,String hour_old,String classroom_old,String day_new,String hour_new,String classroom_new,String quarter){
        int  update = scheduleModel.updateSchedule(day_old,hour_old,classroom_old,day_new,hour_new,classroom_new,quarter);
        return update;
    
    }
}

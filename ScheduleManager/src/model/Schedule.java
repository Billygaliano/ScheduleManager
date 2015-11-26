/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author inftel10
 */
public class Schedule {

    private int classroom;
    private int subject;
    private int year;
    private String day;
    private String hour;
    private String quarter;

    /**
     * Method constructor
     *
     * @param classroom
     * @param subject
     * @param year
     * @param day
     * @param hour
     * @param quarter
     */
    public Schedule(int classroom, int subject, int year, String day, String hour, String quarter) {
        this.classroom = classroom;
        this.subject = subject;
        this.year = year;
        this.day = day;
        this.hour = hour;
        this.quarter = quarter;
    }

    public Schedule() {}

    @Override
    public String toString() {
        return "Schedule{" + "classroom=" + classroom + ", subject=" + subject + ", year=" + year + ", day=" + day + ", hour=" + hour + ", quarter=" + quarter + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.classroom;
        hash = 47 * hash + this.subject;
        hash = 47 * hash + this.year;
        hash = 47 * hash + Objects.hashCode(this.day);
        hash = 47 * hash + Objects.hashCode(this.hour);
        hash = 47 * hash + Objects.hashCode(this.quarter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Schedule other = (Schedule) obj;
        if (this.classroom != other.classroom) {
            return false;
        }
        if (this.subject != other.subject) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        if (!Objects.equals(this.hour, other.hour)) {
            return false;
        }
        if (!Objects.equals(this.quarter, other.quarter)) {
            return false;
        }
        return true;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
    
    public ArrayList<String> returnDaysList(){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<String> days =scheduleDAO.returnDaysList();
        return days;
    }
    
    public ArrayList<String> returnHourList(String day){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<String> hours =scheduleDAO.returnHoursList(day);
        return hours;
    }
    public ArrayList<String> returnClassList(String day,String hour,String subject){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<String> classroom =scheduleDAO.returnClassList(day,hour,subject);
        return classroom;
    }
    
    public void insertSchedule(String titulation,String course,String quarter,String subject,String day,String hour,String classroom,String year){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        scheduleDAO.insertSchedule(titulation,course,quarter,subject,day,hour,classroom,year);

    }
    
    public ArrayList<String> returnOcuppiedDays(String subject){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<String> days = scheduleDAO.returnOcuppiedDays(subject);
        return days;

    }
    
    public ArrayList<String> returnOcuppiedHours(String subject, String day){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<String> hours = scheduleDAO.returnOcuppiedHours(subject,day);
        return hours;
    }
    
    public ArrayList<String> returnOcuppiedClassroom(String day,String hour,String subject){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<String> classroom = scheduleDAO.returnOcuppiedClassroom(day,hour,subject);
        return classroom;
    }
    
    public ArrayList<Schedule> returnSchedules(String quarter, String course, String titulation){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<Schedule> schedules = scheduleDAO.getSchedules(titulation,course,quarter);
        
        return schedules;
    }
}

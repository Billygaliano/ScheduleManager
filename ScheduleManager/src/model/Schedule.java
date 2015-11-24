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

    private Classroom classroom;
    private Subject subject;
    private int year;
    private int day;
    private int hour;
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
    public Schedule(Classroom classroom, Subject subject, int year, int day, int hour, String quarter) {
        this.classroom = classroom;
        this.subject = subject;
        this.year = year;
        this.day = day;
        this.hour = hour;
        this.quarter = quarter;
    }

    public Schedule() {}

    /**
     * Method wich returns a Shedule object in String format.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Schedule{" + "classroom=" + classroom + ", subject=" + subject + ", year=" + year + ", day=" + day + ", hour=" + hour + ", quarter=" + quarter + '}';
    }

    /**
     * Method wich compare Shedules object 
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Schedule other = (Schedule) obj;
        if (!this.classroom.equals(other.classroom)) {
            return false;
        }
        if (!this.subject.equals(other.subject)) {
            return false;
        }
        return true;
    }

    /**
     * Method wich gets classroom's id.
     *
     * @return id_classroom
     */
    public Classroom getId_classroom() {
        return classroom;
    }

    /**
     * Method wich sets classroom's id.
     *
     * @param classroom
     */
    public void setId_classroom(Classroom classroom) {
        this.classroom = classroom;
    }

    /**
     * Method wich gets subject's id.
     *
     * @return id_subject
     */
    public Subject getId_subject() {
        return subject;
    }

    /**
     * Method wich sets subject's id.
     *
     * @param subject
     */
    public void setId_subject(Subject id_subject) {
        this.subject = subject;
    }

    /**
     * Method wich gets Schedule's year.
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Method wich sets Schedule's year.
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Method wich gets Schedule's day.
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Method wich sets Schedule's day.
     *
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Method wich gets Schedule's hour.
     *
     * @return hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * Method wich sets Schedule's hour.
     *
     * @param hour
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Method wich gets Schedule's quarter
     *
     * @return quarter
     */
    public String getQuarter() {
        return quarter;
    }

    /**
     * Method wich sets Schedule's quarter.
     *
     * @param quarter
     */
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
    public ArrayList<String> returnClassList(String day,String hour){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<String> classroom =scheduleDAO.returnClassList(day,hour);
        return classroom;
    }
    
    public void insertSchedule(String titulation,String course,String quarter,String subject,String day,String hour,String classroom){
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        scheduleDAO.insertSchedule(titulation,course,quarter,subject,day,hour,classroom);

    }
}

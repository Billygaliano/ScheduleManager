/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author inftel10
 */
public class Schedule {
    private int id_shedule;
    private int id_classroom;
    private int id_subject;
    private int year;
    private int day;
    private int schedule;
    private String quarter;
    
    /**
     * Method constructor
     * @param id_shedule
     * @param id_classroom
     * @param id_subject
     * @param year
     * @param day
     * @param schedule
     * @param quarter 
     */
    public Schedule(int id_shedule, int id_classroom, int id_subject, int year, int day, int schedule, String quarter) {
        this.id_shedule = id_shedule;
        this.id_classroom = id_classroom;
        this.id_subject = id_subject;
        this.year = year;
        this.day = day;
        this.schedule = schedule;
        this.quarter = quarter;
    }
    
    /**
     * Method wich returns a Aula object in String format.
     * @return String
     */
    @Override
    public String toString() {
        return "Schedule{" + "id_shedule=" + id_shedule + ", id_classroom=" + id_classroom + ", id_subject=" + id_subject + ", year=" + year + ", day=" + day + ", schedule=" + schedule + ", quarter=" + quarter + '}';
    }
    
    
    /**
     * Method wich gets shedule's id.
     * @return id_shedule
     */
    public int getId_shedule() {
        return id_shedule;
    }
    
    /**
     * Method wich sets shedule's id.
     * @param id_shedule 
     */
    public void setId_shedule(int id_shedule) {
        this.id_shedule = id_shedule;
    }
    
    /**
     * Method wich gets classroom's id.
     * @return id_classroom
     */
    public int getId_classroom() {
        return id_classroom;
    }
    
    /**
     * Method wich sets classroom's id.
     * @param id_classroom 
     */
    public void setId_classroom(int id_classroom) {
        this.id_classroom = id_classroom;
    }
    
    /**
     * Method wich gets subject's id.
     * @return id_subject
     */
    public int getId_subject() {
        return id_subject;
    }
    
    /**
     * Method wich sets subject's id.
     * @param id_subject 
     */
    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }
    
    /**
     * Method wich gets Schedule's year.
     * @return year
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Method wich sets Schedule's year.
     * @param year 
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * Method wich gets Schedule's day.
     * @return day
     */
    public int getDay() {
        return day;
    }
    
    /**
     * Method wich sets Schedule's day.
     * @param day 
     */
    public void setDay(int day) {
        this.day = day;
    }
    
    /**
     * Method wich gets Schedules.
     * @return schedule
     */
    public int getSchedule() {
        return schedule;
    }
    /**
     * Method wich sets Schedules.
     * @param schedule 
     */
    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }
    
    /**
     * Method wich gets Schedule's quarter
     * @return quarter
     */
    public String getQuarter() {
        return quarter;
    }
    
    /**
     * Method wich sets Schedule's quarter.
     * @param quarter 
     */
    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
    
    
}

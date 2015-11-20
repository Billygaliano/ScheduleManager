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
    private Classroom classroom;
    private Subject subject;
    private int year;
    private int day;
    private int hour;
    private String quarter;
    
    /**
     * Method constructor
     * @param id_schedule
     * @param classroom
     * @param subject
     * @param year
     * @param day
     * @param schedule
     * @param quarter 
     */
    public Schedule( int id_classroom, int id_subject, int year, int day, int hour, String quarter) {
        this.id_classroom = id_classroom;
        this.id_subject = id_subject;
        this.year = year;
        this.day = day;
        this.hour = hour;
        this.quarter = quarter;
    }
    
    /**
     * Method wich returns a Aula object in String format.
     * @return String
     */
    @Override
    public String toString() {
<<<<<<< HEAD
        return "Schedule{" + "id_shedule=" + id_shedule + ", id_classroom=" + id_classroom + ", id_subject=" + id_subject + ", year=" + year + ", day=" + day + ", schedule=" + hour + ", quarter=" + quarter + '}';
=======
        return "Schedule{" + "id_shedule=" + id_schedule + ", id_classroom=" + classroom + ", id_subject=" + subject + ", year=" + year + ", day=" + day + ", schedule=" + schedule + ", quarter=" + quarter + '}';
>>>>>>> origin/master
    }
    
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Schedule other = (Schedule) obj;
        if (this.id_shedule != other.id_shedule) {
            return false;
        }
        if (this.id_classroom != other.id_classroom) {
            return false;
        }
        if (this.id_subject != other.id_subject) {
            return false;
        }
        return true;
    }
    
    
    
    
    /**
     * Method wich gets shedule's id.
     * @return id_shedule
     */
    public int getId_schedule() {
        return id_schedule;
    }
    
    /**
     * Method wich sets shedule's id.
     * @param id_schedule 
     */
    public void setId_schedule(int id_schedule) {
        this.id_schedule = id_schedule;
    }
    
    /**
     * Method wich gets classroom's id.
     * @return id_classroom
     */
    public Classroom getId_classroom() {
        return classroom;
    }
    
    /**
     * Method wich sets classroom's id.
     * @param classroom 
     */
    public void setId_classroom(Classroom classroom) {
        this.classroom = classroom;
    }
    
    /**
     * Method wich gets subject's id.
     * @return id_subject
     */
    public Subject getId_subject() {
        return subject;
    }
    
    /**
     * Method wich sets subject's id.
     * @param subject 
     */
    public void setId_subject(Subject subject) {
        this.subject = subject;
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
     * Method wich gets Schedule's hour.
     * @return schedule
     */
    public int getHour() {
        return hour;
    }
    /**
     * Method wich sets Schedule's hour.
     * @param schedule 
     */
    public void setHour(int hour) {
        this.hour = hour;
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

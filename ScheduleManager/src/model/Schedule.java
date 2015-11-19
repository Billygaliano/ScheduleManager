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

    public Schedule(int id_shedule, int id_classroom, int id_subject, int year, int day, int schedule, String quarter) {
        this.id_shedule = id_shedule;
        this.id_classroom = id_classroom;
        this.id_subject = id_subject;
        this.year = year;
        this.day = day;
        this.schedule = schedule;
        this.quarter = quarter;
    }
    

    public int getId_shedule() {
        return id_shedule;
    }

    public void setId_shedule(int id_shedule) {
        this.id_shedule = id_shedule;
    }

    public int getId_classroom() {
        return id_classroom;
    }

    public void setId_classroom(int id_classroom) {
        this.id_classroom = id_classroom;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }
    
    
}

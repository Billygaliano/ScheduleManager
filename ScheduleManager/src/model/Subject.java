package model;

import java.util.*;

/**
 * Subject Class
 * @author Guillermo Galiano
 */
public class Subject {
    private int id_subject;
    private int id_titulation;
    private String name;
    private int course;
    private List<User> users;
    private List<Schedule> schedules;

    /**
     * Method wich retuns subject's id.
     * @return id_subject
     */
    public int getId_subject() {
        return id_subject;
    }

    /**
     * Method wich returns titulation's id.
     * @return id_titulation
     */
    public int getId_titulation() {
        return id_titulation;
    }

    /**
     * Method wich returns subject's name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method wich returns subject's course.
     * @return course
     */
    public int getCourse() {
        return course;
    }

    /**
     * Method wich returns a list of users.
     * @return users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Method wich returns a list of schedules.
     * @return  schedules
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }

    /**
     * Method wich sets subject's id.
     * @param id_subject of Subject
     */
    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    /**
     * Method wich sets titulation's id.
     * @param id_titulation of Titulation
     */
    public void setId_titulation(int id_titulation) {
        this.id_titulation = id_titulation;
    }

    /**
     * Method wich sets subject's name.
     * @param name of Subject
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method wich sets subject's course.
     * @param course of Subject
     */
    public void setCourse(int course) {
        this.course = course;
    }

    /**
     * Method wich sets a list of users.
     * @param users of Subject
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    /**
     * Method wich sets a list of schedules.
     * @param schedules of Subject.
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    /**
     * Method wich returns a subject object in String format.
     * @return String
     */
    @Override
    public String toString() {
        return "Subject{" + "id_subject=" + id_subject + ", id_titulation=" + id_titulation + ", name=" + name + ", course=" + course + ", users=" + users + ", schedules=" + schedules + '}';
    }

    /**
     * Class constructor.
     * @param id_subject
     * @param id_titulation
     * @param name
     * @param course
     * @param users
     * @param schedules 
     */
    public Subject(int id_subject, int id_titulation, String name, int course, List<User> users, List<Schedule> schedules) {
        this.id_subject = id_subject;
        this.id_titulation = id_titulation;
        this.name = name;
        this.course = course;
        this.users = users;
        this.schedules = schedules;
    }
    
    
}

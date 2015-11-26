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
    private String course;
    private String quarter;
    private List<User> users;
    private List<Schedule> schedules;

    public Subject() {
    }

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
    public String getCourse() {
        return course;
    }   
    
    /**
     * Method which returns subject's quarter.
     * @return quarter
     */
    public String getQuarter() {
        return quarter;
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
     * @param titulation of Titulation
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
    public void setCourse(String course) {
        this.course = course;
    }    

    /**
     * Method which sets subject's quarter.
     * @param quarter of Subject
     */
    public void setQuarter(String quarter) {
        this.quarter = quarter;
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
        return "Subject{" + "id_subject=" + id_subject + ", id_titulation=" + id_titulation + ", name=" + name + ", course=" + course + ", quarter=" + quarter + ", users=" + users + ", schedules=" + schedules + '}';
    }

    /**
     * Class constructor.
     * @param id_subject
     * @param titulation
     * @param name
     * @param course
     * @param quarter
     * @param users
     * @param schedules 
     */
    public Subject(int id_subject, int id_titulation, String name, String course, String quarter, List<User> users, List<Schedule> schedules) {
        this.id_subject = id_subject;
        this.id_titulation = id_titulation;
        this.name = name;
        this.course = course;
        this.quarter = quarter;
        this.users = users;
        this.schedules = schedules;
    }
    
    /**
     * Method which compares two Subjects
     * return false if both id's are not equal
     * @param sub
     * @return 
     */
    
    public boolean equals(Subject sub){
        boolean a;
        a = (this.id_subject != sub.getId_subject()) ? false :  true;
        return a;
    }
    
    public ArrayList<Subject> returnSubjectList(String titulation, String course, String quarter){
        SubjectDAO subjectDao = new SubjectDAO();
        return subjectDao.getSubjects(titulation, course, quarter);
    }
    
    public ArrayList<String> returnCoursesTitulationUser(String applicant, int id_titulation){
        SubjectDAO subjectDao = new SubjectDAO();
        return subjectDao.getCoursesTitulationUser(applicant, id_titulation);
    }
    
    public ArrayList<String> returnQuartersTitulationUser(String applicant, int id_titulation, String course){
        SubjectDAO subjectDao = new SubjectDAO();
        return subjectDao.getQuartersTitulationUser(applicant, id_titulation, course);
    }
    public ArrayList<String> returnYearsSubjectUser(String applicant){
        SubjectDAO subjectDao = new SubjectDAO();
        return subjectDao.getYearsSubjectUser(applicant);
    }
    
}

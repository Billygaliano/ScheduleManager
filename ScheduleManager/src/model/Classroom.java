/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author macbookpro
 */
public class Classroom {
    private int id_classroom;
    private String name;
    private String type;
    private int capacity;
    private String building;
    private List<Schedule> schedules;
    
    /**
     * Method constructor
     * @param id_classroom
     * @param name
     * @param type
     * @param capacity
     * @param building
     * @param schedules 
     */
    public Classroom(int id_classroom, String name, String type, int capacity, String building, List<Schedule> schedules) {
        this.id_classroom = id_classroom;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.building = building;
        this.schedules = schedules;
    }

    public Classroom() {}
    
    /**
     * Method wich returns a Classroom object in String format.
     * @return String
     */
    @Override
    public String toString() {
        return "Aula{" + "id_classroom=" + id_classroom + ", name=" + name + ", type=" + type + ", capacity=" + capacity + ", building=" + building + ", schedules=" + schedules + '}';
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
     * Method wich gets Classroom's name.
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method wich sets Classroom's name.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Method wich gets Classroom's type.
     * @return type
     */
    public String getType() {
        return type;
    }
    
    /**
     * Method wich sets Classroom's type.
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Method wich gets Classroom's capacity.
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * Method wich sets Classroom's capacity.
     * @param capacity 
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * Method wich gets Classroom's building.
     * @return building
     */
    public String getBuilding() {
        return building;
    }
    
    /**
     * Method wich sets Classroom's building.
     * @param building 
     */
    public void setBuilding(String building) {
        this.building = building;
    }
    
    /**
     * Method which gets a list of schedules.
     * @return schedules
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }
    
    /**
     * Method which sets a list of schedules.
     * @param schedules 
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Classroom other = (Classroom) obj;
        if (this.id_classroom != other.id_classroom) {
            return false;
        }
        return true;
    }
    
    /**
     * Method which compares two classrooms
     * return true if both id's are equal
     * @param clas
     * @return 
     */
    
   
    
    public Classroom returnClassroomById(int idClassroom){
        ClassroomDAO classroomDao = new ClassroomDAO();
        return classroomDao.getClassroomById(idClassroom);
    }
    
       
}

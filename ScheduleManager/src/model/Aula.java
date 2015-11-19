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
public class Aula {
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
    public Aula(int id_classroom, String name, String type, int capacity, String building, List<Schedule> schedules) {
        this.id_classroom = id_classroom;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.building = building;
        this.schedules = schedules;
    }
    
    /**
     * Method wich returns a Aula object in String format.
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
     * Method wich gets Aula's name.
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method wich sets Aula's name.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Method wich gets Aula's type.
     * @return type
     */
    public String getType() {
        return type;
    }
    
    /**
     * Method wich sets Aula's type.
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Method wich gets Aula's capacity.
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * Method wich sets Aula's capacity.
     * @param capacity 
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * Method wich gets Aula's building.
     * @return building
     */
    public String getBuilding() {
        return building;
    }
    
    /**
     * Method wich sets Aula's building.
     * @param building 
     */
    public void setBuilding(String building) {
        this.building = building;
    }
    
    /**
     * Method wich gets a list of schedules.
     * @return schedules
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }
    
    /**
     * Method wich sets a list of schedules.
     * @param schedules 
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
       
}

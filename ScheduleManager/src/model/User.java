package model;

import java.util.*;

/**
 * User Class
 * @author Guillermo Galiano
 */
public class User {
    private String dni;
    private String pass;
    private String email;
    private String name;
    private String surname;
    private String role;
    private Date birthdate;
    private String address;
    private List<Subject> subjects;

    /**
     * Method wich returns user's dni.
     * @return dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Method wich returns user's pass.
     * @return pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Method wich returns user's email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method wich returns user's name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method wich returns user's surname.
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Method wich returns user's role.
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Method wich returns user's birthdate.
     * @return birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Method wich returns user's address.
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method wich returns a list of subjects.
     * @return subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Method wich sets user's dni.
     * @param dni of user
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Method wich sets user's pass.
     * @param pass of user
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Method wich sets user's email.
     * @param email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method wich sets user's name.
     * @param name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method wich sets user's surname.
     * @param surname of user
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Method wich sets user's role.
     * @param role of user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Method wich sets user's birthdate.
     * @param birthdate of user
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Method wich sets user's adderss.
     * @param address of user
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method wich sets a list of subjects.
     * @param subjects is a List of Subject
     */
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * Method wich return a user object in String format.
     * @return String
     */
    @Override
    public String toString() {
        return "User{" + "dni=" + dni + ", pass=" + pass + ", email=" + email + ", name=" + name + ", surname=" + surname + ", role=" + role + ", birthdate=" + birthdate + ", address=" + address + ", subjects=" + subjects + '}';
    }

    /**
     * Class constructor.
     * @param dni
     * @param pass
     * @param email
     * @param name
     * @param surname
     * @param role
     * @param birthdate
     * @param address
     * @param subjects 
     */
    public User(){
        
    }
    
    public User(String dni, String pass, String email, String name, String surname, String role, Date birthdate, String address, List<Subject> subjects) {
        this.dni = dni;
        this.pass = pass;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.birthdate = birthdate;
        this.address = address;
        this.subjects = subjects;
    }
}

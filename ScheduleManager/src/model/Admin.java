/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author inftel10
 */
public class Admin extends User{

    public Admin(String dni, String pass, String email, String name, String surname, String role, Date birthdate, String address, List<Subject> subjects) {
        super(dni, pass, email, name, surname, role, birthdate, address, subjects);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import javax.swing.JLabel;
import persistence.ConnectionDB;
import view.JF_Login;
import view.JF_ViewSchedule;
import schedulemanager.ScheduleManager;

/**
 *
 * @author macbookpro
 */
public class UserDAO {
    ConnectionDB connection;
    Connection con;
    public UserDAO(){
        connection = new ConnectionDB();
        con = connection.connect();
    }
    public User returnUserSection(String dni, String pass){
        User section = new User();
        try {
            PreparedStatement stmt= con.prepareStatement("Select * FROM user_u WHERE DNI = '" + dni + "'");
            ResultSet resultado=stmt.executeQuery();
            while (resultado.next()){
                section.setDni(dni);
                section.setPass(pass);
                section.setEmail(resultado.getString("EMAIL"));
                section.setName(resultado.getString("NAME_USER"));
                section.setSurname(resultado.getString("SURNAME"));
                section.setRole(resultado.getString("USER_ROLE"));
                section.setAddress(resultado.getString("ADDRESS"));
                
            }
        }catch (SQLException ex){
            System.out.println("Error performing query");
        }
        return section;
    }
    
    public boolean returnStartSection(String dni, String pass){
        boolean iniciado = false;  
        try {           
            iniciado = connection.startSection(dni, pass);
        } catch (SQLException ex) {
            System.out.println("Error connect database");
        }
        return iniciado;
    }
    
    public void closeConnection(){
        ConnectionDB.closeConnection();
    }
}

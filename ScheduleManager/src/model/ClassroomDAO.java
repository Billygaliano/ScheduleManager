/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionDB;

/**
 *
 * @author Guillermo Galiano
 */
public class ClassroomDAO {
    ConnectionDB connection;        
    public ClassroomDAO(){
        connection = new ConnectionDB();
    }
    
    public Classroom getClassroomById(int idClassroom){
        Classroom classroom = new Classroom();
        Connection con = connection.connect();
        
        try {
            PreparedStatement stmtClass = con.prepareStatement("SELECT name_classroom, building FROM Classroom WHERE id_classroom = ?");
            stmtClass.setInt(1, idClassroom);
            ResultSet classResult=stmtClass.executeQuery();
            
            while (classResult.next()){
                classroom.setName(classResult.getString("name_classroom"));
                classroom.setBuilding(classResult.getString("building"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return classroom;
    }
}

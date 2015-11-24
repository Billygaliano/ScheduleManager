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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionDB;

/**
 *
 * @author inftel12
 */
public class SubjectDAO {
    ConnectionDB connection;        
    public SubjectDAO(){
        connection = new ConnectionDB();
    }
    
    public ArrayList<Subject> getSubjects(String titulation, String course, String quarter){
        ArrayList<Subject> subjects = new ArrayList();
        Connection con = connection.connect();
        
//        try{
//            PreparedStatement stmtSub = con.prepareStatement("select id_titulation from titulation where name_titulatio = ?");
//            stmt.setString(1, applicant);
//            ResultSet titResult=stmtTit.executeQuery();
//        }catch(){
//            
//        }
//        
//        try {
//            PreparedStatement stmtTit = con.prepareStatement("Select id_titulation, name_tit from titulation");
//            ResultSet titResult=stmtTit.executeQuery();
//            
//            while (titResult.next()){
//                Titulation titulation = new Titulation();
//                
//                titulation.setId_titulation(titResult.getInt("id_titulation"));
//                int id_titulation = titResult.getInt("id_titulation");
//                titulation.setName(titResult.getString("name_tit"));                
//                subjects.add(titulation);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        return subjects;
    }
}

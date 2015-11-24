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
        int id_titulation = 0;
        try{ 
            PreparedStatement stmtTit = con.prepareStatement("select id_titulation from titulation where name_tit=?");
            stmtTit.setString(1, titulation);
            ResultSet resultadoTit=stmtTit.executeQuery();
            
            while (resultadoTit.next()){
                id_titulation = Integer.parseInt(resultadoTit.getString("id_titulation"));
            }
            PreparedStatement stmtSub = con.prepareStatement("select name_subject from subject where id_tit=" 
                    + id_titulation + " and course='" + course +  "' and quarter= '" + quarter + "'");

            ResultSet resultadoSub=stmtSub.executeQuery();
            while (resultadoSub.next()){
                System.out.println(resultadoSub.getString("name_subject"));
                Subject subject = new Subject(); 
                subject.setName(resultadoSub.getString("name_subject"));
                subjects.add(subject);
            }  
        }catch (SQLException ex) {        
        }
        return subjects;
    }
}

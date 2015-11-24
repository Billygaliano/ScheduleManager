/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import persistence.ConnectionDB;

/**
 *
 * @author inftel12
 */
public class TitulationDAO {
    ConnectionDB connection;        
    public TitulationDAO(){
        connection = new ConnectionDB();
    }
    
    public ArrayList<Titulation> getTitulations(){
        ArrayList<Titulation> titulations = new ArrayList();
        Connection con = connection.connect();
        
        try {
            PreparedStatement stmtTit = con.prepareStatement("Select id_titulation, name_tit from titulation");
            ResultSet titResult=stmtTit.executeQuery();
            
            while (titResult.next()){
                Titulation titulation = new Titulation();
                
                titulation.setId_titulation(titResult.getInt("id_titulation"));
                int id_titulation = titResult.getInt("id_titulation");
                titulation.setName(titResult.getString("name_tit"));                
                titulations.add(titulation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return titulations;
    }
    
    public ArrayList<Titulation> getTitulationsSubjects(String applicant){
        ArrayList<Titulation> titulations = new ArrayList();
        Connection con = connection.connect();
        
        try {
            PreparedStatement stmtTit = con.prepareStatement("SELECT id_titulation, name_tit FROM titulation WHERE id_titulation IN (SELECT id_tit FROM subject WHERE id_subject IN(SELECT id_subject FROM subject_user WHERE dni = ?))");
            stmtTit.setString(1, applicant);
            ResultSet titResult=stmtTit.executeQuery();
            
            while (titResult.next()){
                Titulation titulation = new Titulation();
                titulation.setId_titulation(titResult.getInt("id_titulation"));
                titulation.setName(titResult.getString("name_tit"));  
                titulations.add(titulation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return titulations;
    }
}
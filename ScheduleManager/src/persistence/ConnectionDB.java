/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.*;

/**
 *
 * @author macbookpro
 */
public class ConnectionDB {
    public ConnectionDB(){
    }
    
    public Connection getConnection(){
       Connection con = null;
       try{
           Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
           con = DriverManager.getConnection("jdbc:oracle:thin:INFTEL15_5/INFTEL@olimpia.lcc.uma.es:1521:edgar");
       }catch(SQLException ex){
       }catch(Exception e){
       }
       return con;
    }
   
}

package persistence;

import java.sql.*;

/**
 *
 * @author Angie
 */
public class Conexion {
    public Conexion(){}
    
    public Connection getConexion(){
    Connection con=null;
    try{
        Class.forName("oracle.jdbc.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:inftel15_5/INFTEL@olimpia.lcc.uma.es:1521:edgar");
    }catch(SQLException ex){
        System.out.println("No se ha podido establecer conexión" + ex);}
    catch(ClassNotFoundException e){}
    return con;
    }
   
}

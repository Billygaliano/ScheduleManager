package model;

import java.sql.*;
import persistence.ConnectionDB;

/**
 * Class UserDAO
 * @author Group2
 */
public class UserDAO {
    ConnectionDB connection;
    Connection con;
    
    /**
     * Class Constructor
     */
    public UserDAO(){
        connection = new ConnectionDB();
        con = connection.connect();
    }
    
    /**
     * Method that return the user session
     * @param dni
     * @param pass
     * @return User
     */
    public User returnUserSession(String dni, String pass){
        User session = new User();
        try {
            PreparedStatement stmt= con.prepareStatement("Select * FROM user_u WHERE DNI = '" + dni + "'");
            ResultSet resultado=stmt.executeQuery();
            while (resultado.next()){
                session.setDni(dni);
                session.setPass(pass);
                session.setEmail(resultado.getString("EMAIL"));
                session.setName(resultado.getString("NAME_USER"));
                session.setSurname(resultado.getString("SURNAME"));
                session.setRole(resultado.getString("USER_ROLE"));
                session.setAddress(resultado.getString("ADDRESS"));
                
            }
        }catch (SQLException ex){
            System.out.println("Error performing query");
        }
        return session;
    }
    
    /**
     * Method that returns if a user has started a Session
     * @param dni
     * @param pass
     * @return boolean
     */
    public boolean returnStartSession(String dni, String pass){
        boolean iniciado = false;  
        try {           
            iniciado = connection.startSession(dni, pass);
        } catch (SQLException ex) {
            System.out.println("Error connect database");
        }
        return iniciado;
    }
    
    /**
     * Method that close the connection
     */
    public void closeConnection(){
        ConnectionDB.closeConnection();
    }
    
    @Override
    protected void finalize() throws Throwable{
            super.finalize();
            ConnectionDB.closeConnection();
            
        }
}

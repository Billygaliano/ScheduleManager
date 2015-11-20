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
      /*ATRIBUTOS*/
    public Connection conn;
    private Statement statement;
    private String idUsuario;
    private String usuario;
    private String email;
    private String nombre;
    private String pass;
    /*METODOS*/  
    /**
     * @desc Constructor privado de la clase Singleton
     */
    public ConnectionDB() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url= "jdbc:oracle:thin:inftel15_11/INFTEL@olimpia.lcc.uma.es:1521:edgar";
        try {
            Class.forName(driver).newInstance();
            conn = (Connection)DriverManager.getConnection(url);                
        }catch(SQLException ex){
        }catch(Exception e){
        }
    }
     
    
    /**
     * @desc Con este metodo iniciamos la sesion del usuario
     * @param usuario Usuario que quiere conectarse
     * @param pass Contrasenia del mismo usuario
     * @return boolean
     * @throws SQLException 
     */
    public boolean iniciarSesion(String user, String passw) throws SQLException {   
        boolean inciciado = false;
        statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM USER_U WHERE DNI = '"+user+"';");        
        if(rs != null){
            while (rs.next()){                
                String pass = rs.getString("PASS");
                if(pass.equals(passw)){
                    String idUsuario = rs.getString("idUsuario");
                    String usuario = rs.getString("usuario");
                    String email = rs.getString("email");
                    String nombre = rs.getString("nombre");
                    int tiempoLanzamiento = rs.getInt("tiempoLanzamiento");
                    int tiempoEspera = rs.getInt("tiempoEspera");
                     
                    //Cargamos los datos en la sesion actual
                    cargarDatos(idUsuario, usuario, email, nombre, pass);
                     
                    //Guardamos los datos en el fichero
                    Sesion sesion = new Sesion();
                    sesion.escribeDatos(idUsuario, usuario, email, nombre, pass);
                    sesion.escribeTiempos(tiempoLanzamiento, tiempoEspera);
                    sesion.cargaTiempos();                    
                     
                    inciciado = true;                                                            
                }
            }
        }        
        return inciciado;
    } 
}

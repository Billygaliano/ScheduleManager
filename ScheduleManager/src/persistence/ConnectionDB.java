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
    private Connection conexion;
    private Statement sentenciaSQL;
    private ResultSet resul;

    /*METODOS*/
    /**
     * @desc Constructor privado de la clase Singleton
     */
    public ConnectionDB() {
        try {
            String controlador = "oracle.jdbc.driver.OracleDriver";
            Class.forName(controlador);
            conectar();
        } catch (Exception e) {
            System.out.println("Error al cargar el driver");
        }
    }

    private void conectar() {
        String url = "jdbc:oracle:thin:INFTEL15_5/INFTEL@olimpia.lcc.uma.es:1521:edgar";

        try {
            conexion = DriverManager.getConnection(url);
            // crear una sentencia SQL
            sentenciaSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // Mostrar las tablas de la base de datos

        } catch (SQLException ex) {
            System.out.println("Error al conectar con la Base de Datos");
        }
    }

    public ResultSet obtenerTabla(String tabla) {
        try {
            resul = sentenciaSQL.executeQuery("SELECT * FROM " + tabla);
        } catch (SQLException ex) {
            System.out.println("Error al realizar la consulta en la bd");
        }
        return resul;
    }

    public void mostrarFilaActual() throws SQLException {
        int nColumnas = resul.getMetaData().getColumnCount();
        for (int i = 1; i <= nColumnas; ++i) {
            System.out.print(resul.getString(i) + " ");
        }
        System.out.println();
    }

    public void mostrarTabla() throws SQLException {
        while (resul.next()) {
            System.out.println(resul.getString("DNI") + " " + resul.getString("PASS"));
        }
    }

    public void mostrarTabla2(String tabla1) throws SQLException {
        resul = obtenerTabla(tabla1);
        while (resul.next()) {
            mostrarFilaActual();
        }
    }

    /**
     * @desc Con este metodo iniciamos la sesion del usuario
     * @param user Usuario que quiere conectarse
     * @param passw Contrasenia del mismo usuario
     * @return boolean
     * @throws SQLException
     */
    public boolean iniciarSesion(String user, String passw) throws SQLException {
        boolean inciciado = false;
        resul = sentenciaSQL.executeQuery("SELECT * FROM user_u WHERE DNI = '" + user + "'");
        if (resul != null) {
            while (resul.next()) {
                String pass = resul.getString("PASS");
                if (pass.equals(passw)) {
                    inciciado = true;
                }
            }
        }
        return inciciado;
    }

    public void cerrrarconexion() {
        try {
            if (resul != null) {
                resul.close();
            }
            if (sentenciaSQL != null) {
                sentenciaSQL.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            System.out.println("La conexion fue cerrada correctamente");
        } catch (SQLException ex1) {
            System.out.println("Error al cerrar conexion");
        }
    }
}

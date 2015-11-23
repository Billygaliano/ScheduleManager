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
        } catch (Exception e) {
            System.out.println("Error loading the driver");
        }
    }

    public Connection connect() {
        String url = "jdbc:oracle:thin:INFTEL15_5/INFTEL@olimpia.lcc.uma.es:1521:edgar";

        try {
            conexion = DriverManager.getConnection(url);
            // crear una sentencia SQL
            sentenciaSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // Mostrar las tablas de la base de datos

        } catch (SQLException ex) {
            System.out.println("Error connect data base");
        }
        return conexion;
    }

    public ResultSet getTable(String tabla) {
        try {
            resul = sentenciaSQL.executeQuery("SELECT * FROM " + tabla);
        } catch (SQLException ex) {
            System.out.println("Error performing query");
        }
        return resul;
    }

    public void showRow() throws SQLException {
        int nColumnas = resul.getMetaData().getColumnCount();
        for (int i = 1; i <= nColumnas; ++i) {
            System.out.print(resul.getString(i) + " ");
        }
        System.out.println();
    }

    public void showTable() throws SQLException {
        while (resul.next()) {
            System.out.println(resul.getString("DNI") + " " + resul.getString("PASS"));
        }
    }

    public void showTable2(String tabla1) throws SQLException {
        resul = getTable(tabla1);
        while (resul.next()) {
            showRow();
        }
    }

    /**
     * @desc Con este metodo iniciamos la sesion del usuario
     * @param user Usuario que quiere conectarse
     * @param passw Contrasenia del mismo usuario
     * @return boolean
     * @throws SQLException
     */
    public boolean startSection(String user, String passw) throws SQLException {
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

    public void closeConnection() {
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
            System.out.println("The connection was closed successfully");
        } catch (SQLException ex1) {
            System.out.println("Error closing the connection");
        }
    }
}

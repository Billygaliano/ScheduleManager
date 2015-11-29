package persistence;

import java.sql.*;

/**
 * Class ConnectionDB
 * @author Group2
 */
public class ConnectionDB {
    private static Connection conexion;
    private static Statement sentenciaSQL;
    private static ResultSet resul;
  
    /**
     * Class Constructor
     */
    public ConnectionDB() {
        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println("Error loading the driver");
        }
    }
    
    /**
     * Connecting method with data base
     * @return Connection
     */
    public static Connection connect() {
        String url = "jdbc:oracle:thin:INFTEL15_5/INFTEL@olimpia.lcc.uma.es:1521:edgar";

        try {
            conexion = DriverManager.getConnection(url);
            sentenciaSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            System.out.println("Error connect data base");
        }
        
        return conexion;
    }
    
    /**
     * Method which gets ResultSet for a table
     * @param tabla
     * @return ResultSet
     */
    public ResultSet getTable(String tabla) {
        try {
            resul = sentenciaSQL.executeQuery("SELECT * FROM " + tabla);
        } catch (SQLException ex) {
            System.out.println("Error performing query");
        }
        
        return resul;
    }
    
    /**
     * Method that shwos a row
     * @throws SQLException 
     */
    public void showRow() throws SQLException {
        int nColumnas = resul.getMetaData().getColumnCount();
        
        for (int i = 1; i <= nColumnas; ++i) {
            System.out.print(resul.getString(i) + " ");
        }
        
        System.out.println();
    }

    /**
     * Method that shows a table
     * @throws SQLException 
     */
    public void showTable() throws SQLException {
        while (resul.next()) {
            System.out.println(resul.getString("DNI") + " " + resul.getString("PASS"));
        }
    }

    /**
     * Method that show a given table
     * @param table
     * @throws SQLException 
     */
    public void showTable2(String table) throws SQLException {
        resul = getTable(table);
        
        while (resul.next()) {
            showRow();
        }
    }

    /**
     * Method Connection begins with data base
     * @param user
     * @param passw
     * @return inciciado
     * @throws SQLException 
     */
    public boolean startSession(String user, String passw) throws SQLException {
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
    
    /**
     * Static Method that closes connection
     */
    public static void closeConnection() {
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

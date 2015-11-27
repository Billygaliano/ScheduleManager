package model;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionDB;
/**
 *
 * @author Angie
 */
public class RequestDAO {
    ConnectionDB connection;
    public RequestDAO(){
        connection = new ConnectionDB();
    }
    
    /**
     * Method get ArrayList Request for a user
     * @param applicant
     * @return ArrayList Request
     */
    public ArrayList<Request> returnListRequest(String applicant){
        Request request = null;
        Connection con = connection.connect();
        ArrayList<Request> list = new ArrayList();
        try {
            PreparedStatement stmt= con.prepareStatement("Select * from request where dni_applicant=?");
            stmt.setString(1, applicant);
            ResultSet resultado=stmt.executeQuery();
            
            while (resultado.next()){
                request = new Request(); 
                request.setId_request(resultado.getInt("id_request"));
                request.setApplicant(resultado.getString("dni_applicant"));
                request.setSubject(resultado.getString("subject"));
                request.setState(resultado.getString("state_request"));
                request.setMessage(resultado.getString("message"));
                list.add(request);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    /**
     * Method get ArrayList Request for all user
     * @return ArrayList Request
     */
    public ArrayList<Request> returnListRequest1(){
        Request request = null;
        Connection con = connection.connect();
        ArrayList<Request> list = new ArrayList();
        try {
            PreparedStatement stmt= con.prepareStatement("Select * from request");
            ResultSet resultado=stmt.executeQuery();
            
            while (resultado.next()){
                request = new Request(); 
                request.setId_request(resultado.getInt("id_request"));
                request.setApplicant(resultado.getString("dni_applicant"));
                request.setSubject(resultado.getString("subject"));
                request.setState(resultado.getString("state_request"));
                request.setMessage(resultado.getString("message"));
                list.add(request);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    /**
     * Method set the Request
     * @param fila
     * @param status 
     */
    public void SetAdminRequest(int fila,String status){
        Request request = null;
        Request requestModified = null;
        ArrayList<Request> list = new ArrayList();
        Connection con = connection.connect();
        try {
            PreparedStatement stmt= con.prepareStatement("Select id_request,dni_applicant,subject,state_request,message from request");
            ResultSet resultado=stmt.executeQuery();
            
            while (resultado.next()){
                request = new Request();
                request.setId_request(resultado.getInt("id_request"));
                request.setApplicant(resultado.getString("dni_applicant"));
                request.setSubject(resultado.getString("subject"));
                request.setState(resultado.getString("state_request"));
                request.setMessage(resultado.getString("message"));
                list.add(request);
            }
            
            requestModified = new Request();
            requestModified = list.get(fila);
            
            int ID_REQUEST = requestModified.getId_request();
            
           PreparedStatement stmt2 = con.prepareStatement("UPDATE REQUEST SET STATE_REQUEST =? WHERE ID_REQUEST=?");
           stmt2.setString(1, status);
           stmt2.setInt(2, ID_REQUEST);
           stmt2.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        /**
         * Method get true if the insert it is successful
         * @param user
         * @param subject
         * @param text
         * @return boolean
         */
        public boolean insertRequest(String user, String subject, String text){
        boolean ok = false;
        String status = "pendiente";
        Connection con = connection.connect();
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO REQUEST (DNI_APPLICANT, MESSAGE, STATE_REQUEST, SUBJECT) VALUES (?,?,?,?)");
            stmt.setString(1, user);
            stmt.setString(2, text);
            stmt.setString(3, status);
            stmt.setString(4,subject);
            int i = stmt.executeUpdate();
            if (i>0){
                ok=true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ok;
    }
        /**
         * 
         * @throws Throwable 
         */
        @Override
        protected void finalize() throws Throwable{
            super.finalize();
            ConnectionDB.closeConnection();
            
        }
        /**
         * Method get the message request
         * @param idreq
         * @return Request
         */
        public Request returnMessageRequest(int idreq){
        Request request = new Request();
        Connection con = connection.connect();
        try {
            PreparedStatement stmt= con.prepareStatement("Select * from request where id_request=?");
            stmt.setInt(1, idreq);
            ResultSet resultado=stmt.executeQuery();
            
            resultado.next();
            request.setId_request(resultado.getInt("id_request"));
            request.setApplicant(resultado.getString("dni_applicant"));
            request.setSubject(resultado.getString("subject"));
            request.setState(resultado.getString("state_request"));
            request.setMessage(resultado.getString("message"));
  

        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return request;
    }
}
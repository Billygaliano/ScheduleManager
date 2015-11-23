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
    public ArrayList<Request> returnListRequest(String applicant){
        Request request = null;
        Connection con = connection.connect();
        ArrayList<Request> list = new ArrayList();
        try {
            PreparedStatement stmt= con.prepareStatement("Select dni_applicant,subject,state_request,message from request where dni_applicant=?");
            stmt.setString(1, applicant);
            ResultSet resultado=stmt.executeQuery();
            
            while (resultado.next()){
                request = new Request(); 
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
}
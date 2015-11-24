/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;
import model.UserDAO;
import persistence.ConnectionDB;
import view.JF_Login;
import view.JF_ViewSchedule;
/**
 *
 * @author macbookpro
 */
public class ControllerLogin implements ActionListener{



    public void actionPerformed(ActionEvent e,JLabel a,JLabel b,JButton d,JLabel c) {
        Locale locale = new Locale("en", "US");
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("view/Properties/Login", locale);
        a.setText(bundle.getString("JF_Login.name"));
        b.setText(bundle.getString("JF_Login.password"));
        d.setText(bundle.getString("JF_Login.entrar"));
        c.setText(bundle.getString("JF_Login.footer"));
    }
    
    public void actionPerformedEs(ActionEvent e,JLabel a,JLabel b,JButton d,JLabel c) {
        Locale locale = new Locale("es", "ES");
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("view/Properties/Login", locale);
        a.setText(bundle.getString("JF_Login.name"));
        b.setText(bundle.getString("JF_Login.password"));
        d.setText(bundle.getString("JF_Login.entrar"));
        c.setText(bundle.getString("JF_Login.footer"));
    }
    
    public void actionPerformedSignIn(String name,String pass, JLabel jLabelWarning, JF_Login login) {
        UserDAO user = new UserDAO();
        System.out.print(user.returnUserSection(name, pass));
        if(user.returnStartSection(name, pass, jLabelWarning)){
            JF_ViewSchedule api = new JF_ViewSchedule();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new JF_ViewSchedule().setVisible(true);
                    login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                }
            }); 
        }else{
            jLabelWarning.setText("El usuario o contraseña introducido es incorrecto");
            user.closeConnection();
        }
        
    }
    
    public void closeSession(){
        ConnectionDB.closeConnection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

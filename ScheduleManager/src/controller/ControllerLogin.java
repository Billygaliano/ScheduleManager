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
import model.User;
import model.UserDAO;
import persistence.ConnectionDB;
import view.JF_Login;
import view.JF_ViewSchedule;
/**
 *
 * @author macbookpro
 */
public class ControllerLogin implements ActionListener{
    public static JF_Login vistauser;

    /**
     * Method change the language to English 
     * @param e
     * @param name
     * @param password
     * @param signin
     * @param footer 
     */
    public void actionPerformed(ActionEvent e,JLabel name,JLabel password,JButton signin,JLabel footer) {
        Locale locale = new Locale("en", "US");
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("view/Properties/Login", locale);
        name.setText(bundle.getString("JF_Login.name"));
        password.setText(bundle.getString("JF_Login.password"));
        signin.setText(bundle.getString("JF_Login.entrar"));
        footer.setText(bundle.getString("JF_Login.footer"));
    }
    
    /**
     * Method change the language to Spanish
     * @param e
     * @param name
     * @param password
     * @param signin
     * @param footer 
     */
    public void actionPerformedEs(ActionEvent e,JLabel name,JLabel password,JButton signin,JLabel footer) {
        Locale locale = new Locale("es", "ES");
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("view/Properties/Login", locale);
        name.setText(bundle.getString("JF_Login.name"));
        password.setText(bundle.getString("JF_Login.password"));
        signin.setText(bundle.getString("JF_Login.entrar"));
        footer.setText(bundle.getString("JF_Login.footer"));
    }
    
    public void actionPerformedSignIn(String dni,String pass, JLabel jLabelWarning, JF_Login login) {
        User user = new User();
        if(user.returnStartSection(dni, pass)){
            user = user.returnUserSection(dni,pass);
            JF_ViewSchedule api = new JF_ViewSchedule(user);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    vistauser = login;
                    api.setVisible(true);
                    login.setVisible(false);
                }
            }); 
        }else{
            jLabelWarning.setText("El usuario o contraseña introducido es incorrecto");
        }
        
    }
    
    public void closeSession(JF_ViewSchedule section){
        ConnectionDB.closeConnection();
        section.setAlwaysOnTop(false);
        if(JOptionPane.showConfirmDialog (null, new Object[]{"¿Desea cerrar la sesión?"},"JOPtion", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
            section.setVisible(false);
            ControllerLogin.vistauser.setVisible(true);
        }
        else{
        
        }
        //String confirmar = JOptionPane.showInputDialog("Estas seguro de salir de la secion: si o no");
        /*if(confirmar.equalsIgnoreCase("si")){
          ControllerLogin.vistauser.setVisible(true);  
        }else{
        section.setVisible(true);
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

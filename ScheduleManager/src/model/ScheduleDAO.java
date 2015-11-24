/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistence.ConnectionDB;

/**
 *
 * @author inftel11
 */
class ScheduleDAO {

    ConnectionDB connection;

    public ScheduleDAO() {
        connection = new ConnectionDB();
    }

    public ArrayList<String> returnDaysList() {
        ArrayList<String> days = new ArrayList();
        String[] daysArray = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        Connection con = connection.connect();
        try {

            ResultSet num_class = con.createStatement().executeQuery("select count(id_classroom) from classroom");
            num_class.next();
            int num = num_class.getInt(1);
            for (String day : daysArray) {
                ResultSet numhor = con.createStatement().executeQuery("select count(hour_schedule) from schedule where day_schedule='" + day + "'");
                numhor.next();
                int houroccup = numhor.getInt(1);
                if (houroccup < (num * 12)) {
                    days.add(day);
                }
            }
        } catch (SQLException ex) {
        }
        return days;
    }

    public ArrayList<String> returnHoursList(String day){
            
        ArrayList<String> hours = new ArrayList();
        String[] hoursArray = {"8:30-9:30","9:30-10:30","10:30-11:30","11:30-12:30","12:30-13:30","13:30-14:30","15:30-16:30",
                                   "16:30-17:30","17:30-18:30","18:30-19:30","19:30-20:30","20:30-21:30"};
        Connection con = connection.connect();
        try{ 
            ResultSet num_class = con.createStatement().executeQuery("select count(id_classroom) from classroom");
            num_class.next();
            int num = num_class.getInt(1);
            for (String hour : hoursArray) {
                ResultSet num_ocup = con.createStatement().executeQuery("select count(hour_schedule) from schedule where hour_schedule='" + hour + "' and day_schedule='" + day + "'");
                num_ocup.next();
                int houroccup = num_ocup.getInt(1);
                if (houroccup < num) {
                    hours.add(hour);
                }
            }
        } catch (SQLException ex) {
        }
        return hours;
    }
    
       public ArrayList<String> returnClassList(String day,String hour){
            
        ArrayList<String> classroom = new ArrayList();
        ArrayList<Integer> classroom_ocup = new ArrayList();
        StringBuilder x = new StringBuilder("0");
        Connection con = connection.connect();
        try{ 
            ResultSet class_ocup = con.createStatement().executeQuery("select id_classroom from schedule where hour_schedule='" + hour + "' and day_schedule='" + day + "'");
            
            while(class_ocup.next()){
                //classroom_ocup.add(class_ocup.getInt(1));
                x.append(","+class_ocup.getInt(1));
            }
            System.out.println(x);
            ResultSet class_free = con.createStatement().executeQuery("select * from classroom where id_classroom not in ("+x+")");
            while(class_free.next()){
                classroom.add(class_free.getString("NAME_CLASSROOM"));
                System.out.println(class_free.getString("NAME_CLASSROOM"));
            }

        } catch (SQLException ex) {
        }
        
        return classroom;
    }
       
    public void insertSchedule(String titulation,String course,String quarter,String subject,String day,String hour,String classroom){
     
        Connection con = connection.connect();
        try {
            ResultSet rs_class = con.createStatement().executeQuery("select id_classroom from classroom where name_classroom='" + classroom + "'");
            rs_class.next();
            int id_classroom = rs_class.getInt(1);
            
            ResultSet rs_subj = con.createStatement().executeQuery("select id_subject from subject where name_subject='" + subject + "'");
            rs_subj.next();
            int id_subject = rs_subj.getInt(1);  
            System.out.println(id_classroom +" "+ id_subject);
            PreparedStatement stmt = con.prepareStatement("insert into schedule (id_classroom,id_subject,hour_schedule,day_schedule,year_schedule) values(?,?,?,?,2015)");
            stmt.setInt(1,id_classroom);
            stmt.setInt(2,id_subject);
            stmt.setString(3,hour);
            stmt.setString(4,day);
            int i = stmt.executeUpdate();
            System.out.println(i);
        } catch (SQLException ex) {
        }
  
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereview.controller;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Nisa
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/my_movie";
    String DBusername = "root";
    String DBpassword = "";
    
    Connection conn;
    Statement statement;
    String data[][] = new String[500][5];
    
    public Connector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Conenction Success");
        }
        
        catch (Exception ex) {
            System.out.println("Connection Failed" + ex.getMessage());
        }
    }
    
    public String[][] readData() {
        try {
            int totalData = 0;
            String query = "SELECT * FROM movie";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                data[totalData][0] = resultSet.getString("title");
                data[totalData][1] = resultSet.getString("plot");
                data[totalData][2] = resultSet.getString("character");
                data[totalData][3] = resultSet.getString("acting");
                data[totalData][4] = resultSet.getString("score");
                totalData++;
            }
            statement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        finally {
            return data;
        }
    }
    
    public void insertData(String title, String plot, String character, String acting) {
        try {
            int plot1 =  Integer.parseInt(plot);
            int character1 =  Integer.parseInt(character);
            int acting1 =  Integer.parseInt(acting);
            int score = (plot1 + character1 + acting1)/3;
            
            String query =  "INSERT INTO `movie` (`title`, `plot`, `character`, `acting`, `score`) VALUES ('"+title+"','"+plot1+"','"+character1+"','"+acting1+"','"+score+"')";
                    
            statement = conn.createStatement();
            statement. executeUpdate(query);
                   
            System.out.println("Input Success");
            JOptionPane.showMessageDialog(null, "Input Success");
        }
                
        catch (Exception ex) {
        System.out.println("Input Failed");
        }
    }
    
    public void updateData(String title, String plot, String character, String acting){
        try {
            int plot1 =  Integer.parseInt(plot);
            int character1 =  Integer.parseInt(character);
            int acting1 =  Integer.parseInt(acting);
            int score = (plot1 + character1 + acting1)/3;
            
            String query = "UPDATE `movie` SET title = '" + title + "', plot = '" + plot1 + "', character = '" + character1 + "', acting = '" + acting1 + "', score = '" + score + "' WHERE title = '" + title + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Update Success");
            JOptionPane.showMessageDialog(null, "Update Success");
        }
        catch (Exception ex) {
            System.out.println("Update Failed : " + ex.getMessage());
        }
    }
        
    public void deleteData(String title){
        try {
            String query = "DELETE FROM `movie` WHERE title ='" + title + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Successes");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
    
}

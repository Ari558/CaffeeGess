/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author recin
 */


public class ConexionDB {
    
     private static Connection ConnectionDb = null;
    
    public Connection getConnection(){
        
        try {
            String url = "jdbc:mysql://localhost:3306/programacion3";
            String user = "admin";
            String password = "root12.guion";
            
            ConnectionDb = DriverManager.getConnection(url, user, password);
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error no funciona"+e.toString());
        }
        return ConnectionDb;
    }
    
    /*private final String base = "programacion3";
    private final String user = "recinos";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }*/
}

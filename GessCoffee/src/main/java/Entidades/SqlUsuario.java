/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Conexion.ConexionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author recin
 */
public class SqlUsuario extends ConexionDB {
   
    
    ConexionDB con = new ConexionDB();
     Connection conexion = con.getConnection();
     PreparedStatement pd = null;
    public boolean registrar(Resgistro rg){
        
        try {
            String sql = "insert into tbl_registro(Nombre,Password,Numero_Telefono,Correo) values(?,?,?,?)";
            pd = conexion.prepareCall(sql);
            pd.setString(1, rg.getNombre());
            pd.setString(2, rg.getPass());
            pd.setInt(3, rg.getTelefono());
            pd.setString(4, rg.getCorreo());
            
            pd.execute();
            JOptionPane.showMessageDialog(null, "Usuario agregado","Mensaje sistema",1);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e.toString(),"Mensaje sistema",1);
        } 
        return false;
    }
}

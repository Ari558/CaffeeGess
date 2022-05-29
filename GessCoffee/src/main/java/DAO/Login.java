/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author recin
 */
public class Login {
    
     ConexionDB con = new ConexionDB();
     Connection conexion = con.getConnection();
     public Boolean login(Usuario usu){
          
        
         Boolean validar =  false;
         
         try {
               CallableStatement cb = conexion.prepareCall("{call SP_S_USUARIO(?,?)}");
               cb.setString("pusuario", usu.getNombreUsuario());
               cb.setString("Ppassword", usu.getPasword());
            ResultSet resultado = cb.executeQuery();
            int m=0;
            
            while(resultado.next()){
                m+=1;
                
            }
             switch (m) {
                 case 1:JOptionPane.showMessageDialog(null, "Bienvenido");
                     validar = true;
                     break;
                 case 0:
                      JOptionPane.showMessageDialog(null, "Error de usuario");
                      break;
             }
            
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error" + e);
         }
         return validar;
     }
     
     public void addUsuario(Usuario us){
         
         try {
             CallableStatement cb = conexion.prepareCall("{call SP_I_USUARIO(?,?,?)}");
             cb.setString("pusuario", us.getNombreUsuario());
             cb.setString("Ppassword", us.getPasword());
             cb.setInt("prol", us.getRol().ordinal()+1);
             cb.execute();
             JOptionPane.showMessageDialog(null, "EL USUARIO SE HA INGRESADO EN LA BASE DE DATOS CORRECTAMENTE");
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "TODO LO QUE PUDO HABER FALLADO, FALLO!!" + e);
         }
     }
    
}

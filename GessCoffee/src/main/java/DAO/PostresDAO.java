/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Entidades.Postres;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author recin
 */
public class PostresDAO {

ConexionDB con = new ConexionDB();
     Connection conexion = con.getConnection();
      public ArrayList<Postres> ListadoPostres() {
        ArrayList<Postres> listado = null;

        try {
            listado = new ArrayList<Postres>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_POSTRES()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Postres c = new Postres(); 
                c.setIdPostres(resultado.getInt("idtbl_postres"));
                c.setNombrePostres(resultado.getString("Nombre_Postre"));
                c.setPrecioPostre(resultado.getFloat("Precio"));
                listado.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
     
    
      public void AddPostres(Postres p){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_POSTRES(?,?)}");
            cb.setString("PNombre", p.getNombrePostres());
            cb.setFloat("PPrecio", p.getPrecioPostre());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Postre agregado con exito","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistems",1);
            
        }
      }
      public void UpdatePostres(Postres p){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_U_POSTRES(?,?,?)}");
            cb.setInt("pid", p.getIdPostres());
            cb.setString("PNombre", p.getNombrePostres());
            cb.setFloat("PPrecio", p.getPrecioPostre());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Postre actualizado","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistemas",1);
            
        }
      }
         public void DeletePostres(Postres p){
    
        try {
            CallableStatement cb = conexion.prepareCall("delete from tbl_postres as c where c.idtbl_postres = ?");
            cb.setInt(1, p.getIdPostres());
//            cb.setString("pNombre", cl.getNombreClientes());
//            cb.setString("pApellido", cl.getApellidoClientes());
//            cb.setString("pNumero", cl.getNumeroClientes());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Postre eliminado","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error"+ex,"Mensje sistemas",1);
            
        }
      }    
}

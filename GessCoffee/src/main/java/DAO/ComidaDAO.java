/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Entidades.Clientes;
import Entidades.Comida;
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
public class ComidaDAO {
    ConexionDB con = new ConexionDB();
     Connection conexion = con.getConnection();
     
     
      public ArrayList<Comida> ListadoComida() {
        ArrayList<Comida> listado = null;

        try {
            listado = new ArrayList<Comida>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_COMIDA()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Comida c = new Comida();
                c.setIdComida(resultado.getInt("idtbl_comida"));
                c.setNombreComida(resultado.getString("Nombre_Comida"));
                c.setPrecioComida(resultado.getFloat("Precio"));
                listado.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
     
    
      public void AddComida(Comida cc){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_COMIDA(?,?)}");
            cb.setString("PNombre", cc.getNombreComida());
            cb.setFloat("PPrecio", cc.getPrecioComida());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Comida agregada con exito","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistems",1);
            
        }
      }
      public void UpdateComida(Comida cc){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_U_COMIDA(?,?,?)}");
            cb.setInt("pid", cc.getIdComida());
            cb.setString("PNombre", cc.getNombreComida());
            cb.setFloat("PPrecio", cc.getPrecioComida());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Comida actualizada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistemas",1);
            
        }
      }
         public void DeleteComida(Comida cc){
    
        try {
            CallableStatement cb = conexion.prepareCall("delete from tbl_comida as c where c.idtbl_comida = ?");
            cb.setInt(1, cc.getIdComida());
//            cb.setString("pNombre", cl.getNombreClientes());
//            cb.setString("pApellido", cl.getApellidoClientes());
//            cb.setString("pNumero", cl.getNumeroClientes());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Comida eliminada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error"+ex,"Mensje sistemas",1);
            
        }
      }
}

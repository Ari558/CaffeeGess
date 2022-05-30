/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Entidades.Clientes;
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
public class ClientesDAO {
    ConexionDB con = new ConexionDB();
     Connection conexion = con.getConnection();
     
      public ArrayList<Clientes> ListadoClientes() {
        ArrayList<Clientes> listado = null;

        try {
            listado = new ArrayList<Clientes>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_CLIENTES()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Clientes c = new Clientes();
//                es.setIdEstudiante(resultado.getInt("idEstudiante"));
                c.setNombreClientes(resultado.getString("Nombre_Cliente"));
                c.setApellidoClientes(resultado.getString("Apellido_Cliente"));
                c.setNumeroClientes(resultado.getString("Numero_telefono"));
                c.setIdClientes(resultado.getInt("id_clientes"));
                listado.add(c);
            }
            
            

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
      
      
      public void AddClientes(Clientes cl){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_CLIENTES(?,?,?)}");
            cb.setString("pNombre", cl.getNombreClientes());
            cb.setString("pApellido", cl.getApellidoClientes());
            cb.setString("pNumero", cl.getNumeroClientes());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Persona agregada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistems",1);
            
        }
      }
      public void UpdateClientes(Clientes cl){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_U_CLIENTES(?,?,?,?)}");
            cb.setInt(4, cl.getIdClientes());
            cb.setString("pNombre", cl.getNombreClientes());
            cb.setString("pApellido", cl.getApellidoClientes());
            cb.setString("pNumero", cl.getNumeroClientes());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Persona acctualizada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistemas",1);
            
        }
      }
         public void DeleteClientes(Clientes cl){
    
        try {
            CallableStatement cb = conexion.prepareCall("delete from tbl_clientes as c where c.id_clientes = ?");
            cb.setInt(1, cl.getIdClientes());
//            cb.setString("pNombre", cl.getNombreClientes());
//            cb.setString("pApellido", cl.getApellidoClientes());
//            cb.setString("pNumero", cl.getNumeroClientes());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Persona eliminada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error"+ex,"Mensje sistemas",1);
            
        }
      }
      
}

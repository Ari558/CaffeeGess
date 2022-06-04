/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Emuns.forma_pago;
import Emuns.tipoPago;
import Entidades.Clientes;
import Entidades.DetalleOrden;
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
public class DetalleOrdenDAO {
    ConexionDB con = new ConexionDB();
    Connection conexion = con.getConnection();
    
    public ArrayList<DetalleOrden> ListadoDetalleOrden() {
        ArrayList<DetalleOrden> listado = null;

        try {
            listado = new ArrayList<DetalleOrden>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_DETALLE()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                DetalleOrden detalle = new DetalleOrden();    
                detalle.setOrdenfk(resultado.getInt("orden_fk"));
                detalle.setCantidad(resultado.getInt("Camtidad"));
                detalle.setPrecioTotal(resultado.getFloat("Precio_Total"));
                detalle.setForma(forma_pago.Efectivo.tarjetaCredito);
                detalle.setPago(tipoPago.CreditoFiscal.FacturaComercial);
                listado.add(detalle);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
    public void AddClientes(DetalleOrden dt){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_DETALLE(?,?,?,?,?)}");
            cb.setInt("porden", dt.getOrdenfk());
            cb.setInt("pcantidad", dt.getCantidad());
            cb.setFloat("pPrecio", dt.getPrecioTotal());
            cb.setInt("pformaPago", dt.getForma().ordinal()+1);
            cb.setInt("ptipoFactura", dt.getPago().ordinal()+1);
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente agregado","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistems",1);
            
        }
      }
      public void UpdateClientes(DetalleOrden dt){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_U_DETALLE(?,?,?,?)}");
            cb.setInt(1, dt.getIdDetalleOden());
            cb.setInt("porden", dt.getOrdenfk());
            cb.setInt("pcantidad", dt.getCantidad());
            cb.setFloat("pPrecio", dt.getPrecioTotal());
            cb.setString("pformaPago", dt.getForma().toString());
            cb.setString("ptipoFactura", dt.getPago().toString());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente actualizado","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistemas",1);
            
        }
      }
         public void DeleteClientes(DetalleOrden dt){
    
        try {
            CallableStatement cb = conexion.prepareCall("delete from tbl_detalleorden as c where c.idtbl_DetalleOrden = ?");
            cb.setInt(1, dt.getIdDetalleOden());
//            cb.setString("pNombre", cl.getNombreClientes());
//            cb.setString("pApellido", cl.getApellidoClientes());
//            cb.setString("pNumero", cl.getNumeroClientes());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente eliminado","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error"+ex,"Mensje sistemas",1);
            
        }
      }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Entidades.Bebidas;
import Entidades.Orden;
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
public class OrdenDAO {
    ConexionDB con = new ConexionDB();
    Connection conexion = con.getConnection();

    public ArrayList<Orden> ListadoOrden() {
        ArrayList<Orden> listado = null;

        try {
            listado = new ArrayList<Orden>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_ORDEN()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Orden b = new Orden();    
                b.setNumeroOrden(resultado.getInt("NumOrden"));
                b.setClientefk(resultado.getInt("cliente_fk"));
                b.setBebidafk(resultado.getInt("bebida_fk"));
                b.setPostresfk(resultado.getInt("postres_fk"));
                b.setComidafk(resultado.getInt("comida_fk"));
                listado.add(b);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
    public void AddOrden(Orden ord) {

        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_ORDEN(?,?,?,?,?)}");
            cb.setInt("pnumorden", ord.getNumeroOrden());
            cb.setInt("pcliente", ord.getClientefk());
            cb.setInt("pbebida", ord.getBebidafk());
            cb.setInt("pPostres", ord.getPostresfk());
            cb.setInt("pcomida", ord.getComidafk());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Orden agregada", "Mensje sistems", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Mensje sistems", 1);

        }
    }

    public void UpdateOrden(Orden ord) {

        try {
            CallableStatement cb = conexion.prepareCall("{call SP_U_ORDEN(?,?,?,?,?,?)}");
            cb.setInt("pid", ord.getIdOrden());
            cb.setInt("pnumorden", ord.getNumeroOrden());
            cb.setInt("pcliente", ord.getClientefk());
            cb.setInt("pbebida", ord.getBebidafk());
            cb.setInt("pPostres", ord.getPostresfk());
            cb.setInt("pcomida", ord.getComidafk());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Orden actualizada", "Mensje sistems", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Mensje sistemas", 1);

        }
    }

    public void DeleteOrden(Orden ord) {

        try {
            CallableStatement cb = conexion.prepareCall("delete from tbl_orden as c where c.idtbl_Orden = ?");
            cb.setInt(1, ord.getIdOrden());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Orden eliminada", "Mensje sistems", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex, "Mensje sistemas", 1);

        }
    }
}

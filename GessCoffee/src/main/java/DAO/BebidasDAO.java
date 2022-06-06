/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Entidades.Bebidas;
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
public class BebidasDAO {

    ConexionDB con = new ConexionDB();
    Connection conexion = con.getConnection();

    public ArrayList<Bebidas> ListadoBebidas() {
        ArrayList<Bebidas> listado = null;

        try {
            listado = new ArrayList<Bebidas>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_BEBIDA()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Bebidas b = new Bebidas();
                b.setIdBebida(resultado.getInt("idtbl_bebida"));
                b.setNombreBebida(resultado.getString("Nombre_Bebida"));
                b.setPrecioBebida(resultado.getFloat("Precio"));
                listado.add(b);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }

    public void AddBebida(Bebidas bebi) {

        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_BEBIDA(?,?)}");
            cb.setString("PNOmbre", bebi.getNombreBebida());
            cb.setFloat("PPrecio", bebi.getPrecioBebida());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Bebida agregada", "Mensje sistems", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Mensje sistems", 1);

        }
    }

    public void UpdateBebida(Bebidas bebi) {

        try {
            CallableStatement cb = conexion.prepareCall("{call SP_U_BEBIDA(?,?,?)}");
            cb.setInt("pid", bebi.getIdBebida());
            cb.setString("PNOmbre", bebi.getNombreBebida());
            cb.setFloat("PPrecio", bebi.getPrecioBebida());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Bebida actualizada", "Mensje sistems", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Mensje sistemas", 1);

        }
    }

    public void DeleteClientes(Bebidas bebi) {

        try {
            CallableStatement cb = conexion.prepareCall("delete from tbl_bebida as c where c.idtbl_bebida = ?");
            cb.setInt(1, bebi.getIdBebida());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Bebida eliminada", "Mensje sistems", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex, "Mensje sistemas", 1);

        }
    }
}

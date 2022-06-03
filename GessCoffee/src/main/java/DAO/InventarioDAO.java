/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Entidades.Comida;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author recin
 */
public class InventarioDAO {
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
                c.setNombreComida(resultado.getString("Nombre_Bebida"));
                c.setPrecioComida(resultado.getFloat("Precio"));
                listado.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
}

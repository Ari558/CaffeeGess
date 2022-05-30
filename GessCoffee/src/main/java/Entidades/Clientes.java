/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author recin
 */
public class Clientes {
    String NombreClientes;
    String ApellidoClientes;
    String NumeroClientes;
    int idClientes;

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }
    

    public String getNombreClientes() {
        return NombreClientes;
    }

    public void setNombreClientes(String NombreClientes) {
        this.NombreClientes = NombreClientes;
    }

    public String getApellidoClientes() {
        return ApellidoClientes;
    }

    public void setApellidoClientes(String ApellidoClientes) {
        this.ApellidoClientes = ApellidoClientes;
    }

    public String getNumeroClientes() {
        return NumeroClientes;
    }

    public void setNumeroClientes(String NumeroClientes) {
        this.NumeroClientes = NumeroClientes;
    }

    public Clientes() {
    }

    public Clientes(String NombreClientes, String ApellidoClientes, String NumeroClientes) {
        this.NombreClientes = NombreClientes;
        this.ApellidoClientes = ApellidoClientes;
        this.NumeroClientes = NumeroClientes;
    }

    public Clientes(String NombreClientes, String ApellidoClientes, String NumeroClientes, int idClientes) {
        this.NombreClientes = NombreClientes;
        this.ApellidoClientes = ApellidoClientes;
        this.NumeroClientes = NumeroClientes;
        this.idClientes = idClientes;
    }

    
    
}

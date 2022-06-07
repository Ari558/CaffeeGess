/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Emuns.RolType;

/**
 *
 * @author recin
 */
public class Usuario {
   
    //int id;
    String NombreUsuario;
    String Pasword;
    RolType rol;

    public RolType getRol() {
        return rol;
    }

    public void setRol(RolType rol) {
        this.rol = rol;
    }
    

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getPasword() {
        return Pasword;
    }

    public void setPasword(String Pasword) {
        this.Pasword = Pasword;
    }

    public Usuario() {
    }

    public Usuario(String NombreUsuario, String Pasword, RolType rol) {
        this.NombreUsuario = NombreUsuario;
        this.Pasword = Pasword;
        this.rol = rol;
    }

   

    
    
    
}

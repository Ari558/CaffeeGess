/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author recin
 */
public class Bebidas {
    String NombreBebida;
    float PrecioBebida;
    int idBebida;

    public String getNombreBebida() {
        return NombreBebida;
    }

    public void setNombreBebida(String NombreBebida) {
        this.NombreBebida = NombreBebida;
    }

    public float getPrecioBebida() {
        return PrecioBebida;
    }

    public void setPrecioBebida(float PrecioBebida) {
        this.PrecioBebida = PrecioBebida;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public Bebidas(String NombreBebida, float PrecioBebida) {
        this.NombreBebida = NombreBebida;
        this.PrecioBebida = PrecioBebida;
    }

    public Bebidas(String NombreBebida, float PrecioBebida, int idBebida) {
        this.NombreBebida = NombreBebida;
        this.PrecioBebida = PrecioBebida;
        this.idBebida = idBebida;
    }

    public Bebidas() {
        
    }


    
    
}

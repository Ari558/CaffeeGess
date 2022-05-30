/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author recin
 */
public class Comida {
    String NombreComida;
    float PrecioComida;
    int idComida;

    public String getNombreComida() {
        return NombreComida;
    }

    public void setNombreComida(String NombreComida) {
        this.NombreComida = NombreComida;
    }

    public float getPrecioComida() {
        return PrecioComida;
    }

    public void setPrecioComida(float PrecioComida) {
        this.PrecioComida = PrecioComida;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public Comida() {
    }

    
    public Comida(String NombreComida, float PrecioComida) {
        this.NombreComida = NombreComida;
        this.PrecioComida = PrecioComida;
    }

    public Comida(String NombreComida, float PrecioComida, int idComida) {
        this.NombreComida = NombreComida;
        this.PrecioComida = PrecioComida;
        this.idComida = idComida;
    }
    
}

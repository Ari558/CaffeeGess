/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author recin
 */
public class Postres {
    String NombrePostres;
    float PrecioPostre;
    int idPostres;

    public String getNombrePostres() {
        return NombrePostres;
    }

    public void setNombrePostres(String NombrePostres) {
        this.NombrePostres = NombrePostres;
    }

    public float getPrecioPostre() {
        return PrecioPostre;
    }

    public void setPrecioPostre(float PrecioPostre) {
        this.PrecioPostre = PrecioPostre;
    }

    public int getIdPostres() {
        return idPostres;
    }

    public void setIdPostres(int idPostres) {
        this.idPostres = idPostres;
    }

    public Postres() {
    }

    public Postres(String NombrePostres, float PrecioPostre) {
        this.NombrePostres = NombrePostres;
        this.PrecioPostre = PrecioPostre;
    }

    public Postres(String NombrePostres, float PrecioPostre, int idPostres) {
        this.NombrePostres = NombrePostres;
        this.PrecioPostre = PrecioPostre;
        this.idPostres = idPostres;
    }
    
}

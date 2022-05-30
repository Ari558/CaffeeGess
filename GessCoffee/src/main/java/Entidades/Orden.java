/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author recin
 */
public class Orden {
    int NumeroOrden;
    int clientefk;
    int bebidafk;
    int postresfk;
    int comidafk;
    int idOrden;

    public int getNumeroOrden() {
        return NumeroOrden;
    }

    public void setNumeroOrden(int NumeroOrden) {
        this.NumeroOrden = NumeroOrden;
    }

    public int getClientefk() {
        return clientefk;
    }

    public void setClientefk(int clientefk) {
        this.clientefk = clientefk;
    }

    public int getBebidafk() {
        return bebidafk;
    }

    public void setBebidafk(int bebidafk) {
        this.bebidafk = bebidafk;
    }

    public int getPostresfk() {
        return postresfk;
    }

    public void setPostresfk(int postresfk) {
        this.postresfk = postresfk;
    }

    public int getComidafk() {
        return comidafk;
    }

    public void setComidafk(int comidafk) {
        this.comidafk = comidafk;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Orden(int NumeroOrden, int clientefk, int bebidafk, int comidafk) {
        this.NumeroOrden = NumeroOrden;
        this.clientefk = clientefk;
        this.bebidafk = bebidafk;
        this.comidafk = comidafk;
    }

    public Orden(int NumeroOrden, int clientefk, int bebidafk, int postresfk, int comidafk, int idOrden) {
        this.NumeroOrden = NumeroOrden;
        this.clientefk = clientefk;
        this.bebidafk = bebidafk;
        this.postresfk = postresfk;
        this.comidafk = comidafk;
        this.idOrden = idOrden;
    }
    
    
}

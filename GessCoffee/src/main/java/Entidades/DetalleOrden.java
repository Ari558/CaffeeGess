/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Emuns.forma_pago;
import Emuns.tipoPago;

/**
 *
 * @author recin
 */
public class DetalleOrden {
    forma_pago forma;
    tipoPago pago;
    int idDetalleOden;
    int ordenfk;
    int Cantidad;
    float precioTotal;
    

    public forma_pago getForma() {
        return forma;
    }

    public void setForma(forma_pago forma) {
        this.forma = forma;
    }

    public tipoPago getPago() {
        return pago;
    }

    public void setPago(tipoPago pago) {
        this.pago = pago;
    }

    public int getIdDetalleOden() {
        return idDetalleOden;
    }

    public void setIdDetalleOden(int idDetalleOden) {
        this.idDetalleOden = idDetalleOden;
    }

    public int getOrdenfk() {
        return ordenfk;
    }

    public void setOrdenfk(int ordenfk) {
        this.ordenfk = ordenfk;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public DetalleOrden() {
    }

    public DetalleOrden(forma_pago forma, tipoPago pago, int ordenfk, int Cantidad, float precioTotal) {
        this.forma = forma;
        this.pago = pago;
        this.ordenfk = ordenfk;
        this.Cantidad = Cantidad;
        this.precioTotal = precioTotal;
    }

    public DetalleOrden(forma_pago forma, tipoPago pago, int idDetalleOden, int ordenfk, int Cantidad, float precioTotal) {
        this.forma = forma;
        this.pago = pago;
        this.idDetalleOden = idDetalleOden;
        this.ordenfk = ordenfk;
        this.Cantidad = Cantidad;
        this.precioTotal = precioTotal;
    }
    
}

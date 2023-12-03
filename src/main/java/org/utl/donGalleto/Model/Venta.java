package org.utl.donGalleto.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private long idVenta;

    @Column(name = "cantidad")
    String cantidad;

    @Column(name = "total")
    String total;

    @Column(name = "id_galleta")
    long idGalleta;

    public Venta() {
    }

    public Venta(String cantidad, String total, long idGalleta) {
        this.cantidad = cantidad;
        this.total = total;
        this.idGalleta = idGalleta;
    }

    public Venta(long idVenta, String cantidad, String total, long idGalleta) {
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.total = total;
        this.idGalleta = idGalleta;
    }

    public Venta(String cantidad, String total) {
        this.cantidad = cantidad;
        this.total = total;
    }

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public long getIdGalleta() {
        return idGalleta;
    }

    public void setIdGalleta(long idGalleta) {
        this.idGalleta = idGalleta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", cantidad='" + cantidad + '\'' +
                ", total='" + total + '\'' +
                ", idGalleta=" + idGalleta +
                '}';
    }
}

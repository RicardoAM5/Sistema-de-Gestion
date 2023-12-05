package org.utl.donGalleto.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private long idInventario;
    @Column(name = "cantidad")
    String cantidad;
    @Column(name = "id_galleta")
    long idGalleta;

    public Inventario() {
    }

    public Inventario(String cantidad, long idGalleta) {
        this.cantidad = cantidad;
        this.idGalleta = idGalleta;
    }

    public Inventario(long idInventario, String cantidad, long idGalleta) {
        this.idInventario = idInventario;
        this.cantidad = cantidad;
        this.idGalleta = idGalleta;
    }

    public long getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(long idInventario) {
        this.idInventario = idInventario;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public long getIdGalleta() {
        return idGalleta;
    }

    public void setIdGalleta(long idGalleta) {
        this.idGalleta = idGalleta;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "idInventario=" + idInventario +
                ", cantidad='" + cantidad + '\'' +
                ", idGalleta=" + idGalleta +
                '}';
    }
}

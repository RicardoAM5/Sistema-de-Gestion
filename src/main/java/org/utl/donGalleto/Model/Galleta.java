package org.utl.donGalleto.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "galleta")
public class Galleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_galleta")
    private long idGalleta;

    @Column(name = "nombre")
    String nombre;
    @Column(name = "precio_unitario")
    String precioUnitario;
    @Column(name = "precio_kilo")
    String precioKilo;
    @Column(name = "imagen_base64")
    String imagenBase64;
    @Column(name = "descripcion")
    String descripcion;

    public Galleta() {
    }

    public Galleta(String nombre, String precioUnitario, String precioKilo, String imagenBase64, String descripcion) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioKilo = precioKilo;
        this.imagenBase64 = imagenBase64;
        this.descripcion = descripcion;
    }

    public Galleta(long idGalleta, String nombre, String precioUnitario, String precioKilo, String imagenBase64, String descripcion) {
        this.idGalleta = idGalleta;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioKilo = precioKilo;
        this.imagenBase64 = imagenBase64;
        this.descripcion = descripcion;
    }

    public long getIdGalleta() {
        return idGalleta;
    }

    public void setIdGalleta(long idGalleta) {
        this.idGalleta = idGalleta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getPrecioKilo() {
        return precioKilo;
    }

    public void setPrecioKilo(String precioKilo) {
        this.precioKilo = precioKilo;
    }

    public String getImagenBase64() {
        return imagenBase64;
    }

    public void setImagenBase64(String imagenBase64) {
        this.imagenBase64 = imagenBase64;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

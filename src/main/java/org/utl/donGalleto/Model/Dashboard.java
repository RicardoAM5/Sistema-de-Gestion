package org.utl.donGalleto.Model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Dashboard {

    String nombreGalleta;
    Date fecha;
    float cantidadVendida;


    public Dashboard() {
    }

    public Dashboard(String nombreGalleta, Date fecha, float cantidadVendida) {
        this.nombreGalleta = nombreGalleta;
        this.fecha = fecha;
        this.cantidadVendida = cantidadVendida;
    }

    public String getNombreGalleta() {
        return nombreGalleta;
    }

    public void setNombreGalleta(String nombreGalleta) {
        this.nombreGalleta = nombreGalleta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(float cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}

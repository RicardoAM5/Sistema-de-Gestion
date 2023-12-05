package org.utl.donGalleto.Model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Dashboard {

    String nombreGalleta;
    float cantidadVendida;


    public Dashboard() {
    }

    public Dashboard(String nombreGalleta, float cantidadVendida) {
        this.nombreGalleta = nombreGalleta;
        this.cantidadVendida = cantidadVendida;
    }



    public String getNombreGalleta() {
        return nombreGalleta;
    }

    public void setNombreGalleta(String nombreGalleta) {
        this.nombreGalleta = nombreGalleta;
    }

    public float getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(float cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}

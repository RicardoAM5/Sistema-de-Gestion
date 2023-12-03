package org.utl.donGalleto.CQRS;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.DAO.GalletaDAO;
import org.utl.donGalleto.Model.Galleta;

import java.util.ArrayList;
import java.util.List;

@Service
public class GalletaCQRS {

    private final GalletaDAO galletaDAO;

    public GalletaCQRS(GalletaDAO galletaDAO) {
        this.galletaDAO = galletaDAO;
    }

    public Galleta insertarGalleta(Galleta g) throws Exception {
        List<String> camposVacios = new ArrayList<>();

        if (g.getNombre() == null || g.getNombre().isEmpty() ) {
            camposVacios.add("nombre");
        }
        if (g.getPrecioUnitario() == null || g.getPrecioUnitario().isEmpty() ) {
            camposVacios.add("precioUnitario");
        }
        if (g.getPrecioKilo() == null || g.getPrecioKilo().isEmpty() ) {
            camposVacios.add("precioKilo");
        }
        if (g.getImagenBase64() == null || g.getImagenBase64().isEmpty() ) {
            camposVacios.add("imagen");
        }
        if (g.getDescripcion() == null || g.getDescripcion().isEmpty() ) {
            camposVacios.add("descripcion");
        }
            if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
            galletaDAO.insertarGalleta(g);

        return g;
    }
    public Galleta actualizarGalleta(Galleta g) throws Exception {
        List<String> camposVacios = new ArrayList<>();

        if (g.getNombre() == null || g.getNombre().isEmpty() ) {
            camposVacios.add("nombre");
        }
        if (g.getPrecioUnitario() == null || g.getPrecioUnitario().isEmpty() ) {
            camposVacios.add("precioUnitario");
        }
        if (g.getPrecioKilo() == null || g.getPrecioKilo().isEmpty() ) {
            camposVacios.add("precioKilo");
        }
        if (g.getImagenBase64() == null || g.getImagenBase64().isEmpty() ) {
            camposVacios.add("imagen");
        }
        if (g.getDescripcion() == null || g.getDescripcion().isEmpty() ) {
            camposVacios.add("descripcion");
        }
        if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        galletaDAO.actualizarGalleta(g);

        return g;
    }
}

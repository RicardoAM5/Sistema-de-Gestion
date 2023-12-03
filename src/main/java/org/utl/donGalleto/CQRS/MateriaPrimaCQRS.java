package org.utl.donGalleto.CQRS;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.DAO.MateriaPrimaDAO;
import org.utl.donGalleto.Model.MateriaPrima;


import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaPrimaCQRS {
    private final MateriaPrimaDAO materiaPrimaDAO;

    public MateriaPrimaCQRS(MateriaPrimaDAO materiaPrimaDAO) {
        this.materiaPrimaDAO = materiaPrimaDAO;
    }

    public MateriaPrima insertarMateriaPrima(MateriaPrima ma) throws Exception {
        List<String> camposVacios = new ArrayList<>();

        if (ma.getIngrediente() == null || ma.getIngrediente().isEmpty() ) {
            camposVacios.add("nombre");
        }
        if (ma.getPeso() == null || ma.getPeso().isEmpty() ) {
            camposVacios.add("precioUnitario");
        }

        if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        materiaPrimaDAO.insertarMateriaPrima(ma);

        return ma;
    }
    public MateriaPrima actualizarMateriaPrima(MateriaPrima ma) throws Exception {
        List<String> camposVacios = new ArrayList<>();

        if (ma.getIngrediente() == null || ma.getIngrediente().isEmpty() ) {
            camposVacios.add("nombre");
        }
        if (ma.getPeso() == null || ma.getPeso().isEmpty() ) {
            camposVacios.add("precioUnitario");
        }

        if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        materiaPrimaDAO.actualizarMateriaPrima(ma);

        return ma;
    }
}

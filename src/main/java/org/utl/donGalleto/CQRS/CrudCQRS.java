package org.utl.donGalleto.CQRS;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.DAO.CrudDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrudCQRS {

    private final CrudDAO inventarioDAO;

    public CrudCQRS(CrudDAO inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }

    public org.utl.donGalleto.Model.Crud insertarInventario(org.utl.donGalleto.Model.Crud i) throws Exception{
        List<String> camposVacios = new ArrayList<>();

        if(i.getCantidad() == null || i.getCantidad().isEmpty() ){
            camposVacios.add("cantidad");
        }
        if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        inventarioDAO.insertarInventario(i);
        return i;
    }
    public org.utl.donGalleto.Model.Crud actualizarInventario(org.utl.donGalleto.Model.Crud i) throws Exception{
        List<String> camposVacios = new ArrayList<>();

        if(i.getCantidad() == null || i.getCantidad().isEmpty() ){
            camposVacios.add("cantidad");
        }
        if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        inventarioDAO.actualizarInventario(i);
        return i;
    }
}

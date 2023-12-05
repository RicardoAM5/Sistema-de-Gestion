package org.utl.donGalleto.CQRS;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.DAO.InventarioDAO;
import org.utl.donGalleto.Model.Inventario;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventarioCQRS {

    private final InventarioDAO inventarioDAO;

    public InventarioCQRS(InventarioDAO inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }

    public Inventario insertarInventario(Inventario i) throws Exception{
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
    public Inventario actualizarInventario(Inventario i) throws Exception{
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

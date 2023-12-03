package org.utl.donGalleto.CQRS;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.DAO.VentaDAO;
import org.utl.donGalleto.Model.Venta;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaCQRS {
    private final VentaDAO ventaDAO;

    public VentaCQRS(VentaDAO ventaDAO) {
        this.ventaDAO = ventaDAO;
    }


    public Venta insertarVenta(Venta v) throws Exception{
        List<String> camposVacios = new ArrayList<>();
        if(v.getCantidad() == null || v.getCantidad().isEmpty()){
            camposVacios.add("cantidad");
        }
        if(v.getTotal() == null || v.getTotal().isEmpty()){
            camposVacios.add("total");
        }
        if(v.getCantidad().isEmpty()){
            camposVacios.add("galleta");
        }
         if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        ventaDAO.insertarVenta(v);
        return v;

    }
    public Venta actualizarVenta(Venta v) throws Exception{
        List<String> camposVacios = new ArrayList<>();
        if(v.getCantidad() == null || v.getCantidad().isEmpty()){
            camposVacios.add("cantidad");
        }
        if(v.getTotal() == null || v.getTotal().isEmpty()){
            camposVacios.add("total");
        }
        if(v.getCantidad().isEmpty()){
            camposVacios.add("galleta");
        }
        if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        ventaDAO.insertarVenta(v);
        return v;

    }
}

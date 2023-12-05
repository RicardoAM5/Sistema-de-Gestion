package org.utl.donGalleto.AppService;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.DAO.InventarioDAO;
import org.utl.donGalleto.Model.Inventario;

import java.util.List;

@Service
public class InventarioAppService {
    private final InventarioDAO inventarioDAO;

    public InventarioAppService(InventarioDAO inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }

    public String actualizarInventario (String nombre, String cantidad) throws Exception {
        return inventarioDAO.actualizarInventario(nombre,cantidad);
    }

    public List<Inventario> getAllInventario() throws Exception {
        return inventarioDAO.getAllInventario();
    }
}

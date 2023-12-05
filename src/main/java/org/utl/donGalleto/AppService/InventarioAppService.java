package org.utl.donGalleto.AppService;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import org.utl.donGalleto.CQRS.InventarioCQRS;
import org.utl.donGalleto.DAO.InventarioDAO;
import org.utl.donGalleto.Model.Inventario;


import java.util.List;
import java.util.Optional;

@Service
public class InventarioAppService {

    private final InventarioDAO inventarioDAO;
    private final InventarioCQRS inventarioCQRS;

    public InventarioAppService(InventarioDAO inventarioDAO, InventarioCQRS inventarioCQRS) {
        this.inventarioDAO = inventarioDAO;
        this.inventarioCQRS = inventarioCQRS;
    }

    public void insertarInventario(Inventario i) throws Exception {
        inventarioCQRS.insertarInventario(i);
    }

    public void actualizarInventario(Inventario i) throws Exception {
    inventarioCQRS.actualizarInventario(i);
    }

    public List<Inventario> getAllInventario() {
        return inventarioDAO.getAllInventario();
    }

    public Optional<Inventario> buscarInventario(long idInventario) {
        return inventarioDAO.buscarInventario(idInventario);
    }

    public void eliminarInventario(long idInventario) throws Exception {
        try {
            inventarioDAO.eliminarInventario(idInventario);
        } catch (Exception e) {
            throw new Exception("No se encontro inventario con el id " + idInventario);
        }
    }


}

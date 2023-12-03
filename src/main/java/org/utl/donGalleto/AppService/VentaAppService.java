package org.utl.donGalleto.AppService;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.CQRS.VentaCQRS;
import org.utl.donGalleto.DAO.VentaDAO;
import org.utl.donGalleto.Model.Venta;

import java.util.List;
import java.util.Optional;

@Service
public class VentaAppService {

    private final VentaDAO ventaDAO;
    private final VentaCQRS ventaCQRS;

    public VentaAppService(VentaDAO ventaDAO, VentaCQRS ventaCQRS) {
        this.ventaDAO = ventaDAO;
        this.ventaCQRS = ventaCQRS;
    }

    public void insertarVenta(Venta v)throws Exception{
        ventaCQRS.insertarVenta(v);
    }

    public void actualizarVenta(Venta v)throws Exception{
        ventaCQRS.actualizarVenta(v);
    }

    public List<Venta> getAllVenta(){
        return ventaDAO.getAllVenta();
    }

    public Optional<Venta> buscarVenta(long idVenta){
        return ventaDAO.buscarVenta(idVenta);
    }

    public void eliminarVenta(long idVenta) throws Exception {
        try {
            ventaDAO.eliminarVenta(idVenta);
        } catch (Exception e) {
            throw new Exception("No se encontro el usuario con el id " + idVenta);
        }
    }
}

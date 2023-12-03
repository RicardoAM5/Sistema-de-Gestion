package org.utl.donGalleto.DAO;

import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Venta;
import org.utl.donGalleto.Repositorio.RepositorioVenta;

import java.util.List;
import java.util.Optional;

@Repository
public class VentaDAO {
    private final RepositorioVenta repositorioVenta;

    public VentaDAO(RepositorioVenta repositorioVenta) {
        this.repositorioVenta = repositorioVenta;
    }

    public void insertarVenta(Venta v) {
        repositorioVenta.save(v);
    }

    public List<Venta> getAllVenta(){
        return repositorioVenta.findAll();
    }

    public void eliminarVenta( long idVenta){
        repositorioVenta.deleteById(idVenta);
    }

    public void actualizrVenta(Venta v){
        repositorioVenta.save(v);
    }

    public Optional<Venta> buscarVenta(long idVenta){
        return repositorioVenta.findById(idVenta);
    }



}

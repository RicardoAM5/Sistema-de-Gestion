package org.utl.donGalleto.DAO;

import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Inventario;
import org.utl.donGalleto.Repositorio.RepositorioInventario;

import java.util.List;
import java.util.Optional;

@Repository
public class InventarioDAO {

    private final RepositorioInventario repositorioInventario;


    public InventarioDAO(RepositorioInventario repositorioInventario) {
        this.repositorioInventario = repositorioInventario;
    }


    public void insertarInventario(Inventario i) {
        repositorioInventario.save(i);
    }

    public List<Inventario> getAllInventario(){
        return repositorioInventario.findAll();
    }

    public Optional<Inventario> buscarInventario(long idInventario){
        return repositorioInventario.findById(idInventario);
    }

    public void eliminarInventario(long idInventario){
        repositorioInventario.deleteById(idInventario);
    }

    public Inventario actualizarInventario(Inventario i){
        repositorioInventario.save(i);
        return i;
    }

}

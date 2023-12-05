package org.utl.donGalleto.DAO;

import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Repositorio.RepositorioCrud;

import java.util.List;
import java.util.Optional;

@Repository
public class CrudDAO {

    private final RepositorioCrud repositorioInventario;


    public CrudDAO(RepositorioCrud repositorioInventario) {
        this.repositorioInventario = repositorioInventario;
    }


    public void insertarInventario(org.utl.donGalleto.Model.Crud i) {
        repositorioInventario.save(i);
    }

    public List<org.utl.donGalleto.Model.Crud> getAllInventario(){
        return repositorioInventario.findAll();
    }

    public Optional<org.utl.donGalleto.Model.Crud> buscarInventario(long idInventario){
        return repositorioInventario.findById(idInventario);
    }

    public void eliminarInventario(long idInventario){
        repositorioInventario.deleteById(idInventario);
    }

    public org.utl.donGalleto.Model.Crud actualizarInventario(org.utl.donGalleto.Model.Crud i){
        repositorioInventario.save(i);
        return i;
    }

}

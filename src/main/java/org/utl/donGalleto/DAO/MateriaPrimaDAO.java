package org.utl.donGalleto.DAO;

import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.MateriaPrima;
import org.utl.donGalleto.Repositorio.RepositorioMateriaPrima;

import java.util.List;
import java.util.Optional;

@Repository
public class MateriaPrimaDAO {
    private final RepositorioMateriaPrima repositorioMateriaPrima;

    public MateriaPrimaDAO(RepositorioMateriaPrima repositorioMateriaPrima) {
        this.repositorioMateriaPrima = repositorioMateriaPrima;
    }

    public void insertarMateriaPrima(MateriaPrima ma) {
        repositorioMateriaPrima.save(ma);
    }

    public List<MateriaPrima> getAllMateriaPrima(){
        return repositorioMateriaPrima.findAll();
    }

    public Optional<MateriaPrima> buscarMateriaPrima(long idMateriaPrima){
        return repositorioMateriaPrima.findById(idMateriaPrima);
    }

    public void eliminarMateriaPrima(long idMateriaPrima){
        repositorioMateriaPrima.deleteById(idMateriaPrima);
    }

    public MateriaPrima actualizarMateriaPrima(MateriaPrima ma){
        repositorioMateriaPrima.save(ma);
        return ma;
    }

}

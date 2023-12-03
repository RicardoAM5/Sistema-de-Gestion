package org.utl.donGalleto.DAO;

import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Usuario;
import org.utl.donGalleto.Repositorio.RepositorioUsuario;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDAO {

    private final RepositorioUsuario repositorioUsuario;

    public UsuarioDAO(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void insertarUsuario(Usuario u){
        repositorioUsuario.save(u);
    }

    public List<Usuario> getAllUsuario(){
        return  repositorioUsuario.findAll();
    }

    public Optional<Usuario> buscarUsuario(long idUsuario){
        return repositorioUsuario.findById(idUsuario);
    }

    public void eliminarUsuario(long idUsuario){
        repositorioUsuario.deleteById(idUsuario);
    }

    public Usuario actualizarUsuario(Usuario u){
        return repositorioUsuario.save(u);
    }

}

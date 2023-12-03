package org.utl.donGalleto.AppService;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.CQRS.UsuarioCQRS;
import org.utl.donGalleto.DAO.UsuarioDAO;
import org.utl.donGalleto.Model.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioAppService {

    private final UsuarioDAO usuarioDAO;
    private final UsuarioCQRS usuarioCQRS;

    public UsuarioAppService(UsuarioDAO usuarioDAO, UsuarioCQRS usuarioCQRS) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioCQRS = usuarioCQRS;
    }

    public void insertarUsuario(Usuario u) throws Exception {
        usuarioCQRS.insertarUsuario(u);
    }

    public void actualizarUsuario(Usuario u) throws Exception {
        usuarioCQRS.actualizarUsuario(u);
    }

    public List<Usuario> getAllUsuario() {
        return usuarioDAO.getAllUsuario();
    }
    public Optional<Usuario> buscarUsuario(long idUsuario) {
        return usuarioDAO.buscarUsuario(idUsuario);
    }

    public void eliminarUsuario(long idUsuario) throws Exception{
        try {
            usuarioDAO.eliminarUsuario(idUsuario);
        } catch (Exception e) {
            throw new Exception("No se encontro el usuario con el id " + idUsuario);
        }
    }
}

package org.utl.donGalleto.CQRS;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.DAO.UsuarioDAO;
import org.utl.donGalleto.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioCQRS {

    private final UsuarioDAO usuarioDAO;

    public UsuarioCQRS(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario insertarUsuario(Usuario u) throws Exception {
        List<String> camposVacios = new ArrayList<>();
        if (u.getNombre() == null || u.getNombre().isEmpty()) {
            camposVacios.add("usuario");
        }
        if (u.getContrasenia() == null || u.getContrasenia().isEmpty()) {
            camposVacios.add("contrasenia");
        }
        if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios: " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        usuarioDAO.insertarUsuario(u);
        return u;
    }
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        List<String> camposVacios = new ArrayList<>();
        if (u.getNombre() == null || u.getNombre().isEmpty()) {
            camposVacios.add("usuario");
        }
        if (u.getContrasenia() == null || u.getContrasenia().isEmpty()) {
            camposVacios.add("contrasenia");
        }
        if (!camposVacios.isEmpty()) {
            String emptyMessage = "Estos campos no pueden estar vacios: " + String.join(", ", camposVacios);
            throw new Exception(emptyMessage);
        }
        usuarioDAO.actualizarUsuario(u);
        return u;
    }
}

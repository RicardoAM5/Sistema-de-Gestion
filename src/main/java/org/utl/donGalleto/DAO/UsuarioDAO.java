package org.utl.donGalleto.DAO;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Usuario;
import org.utl.donGalleto.Repositorio.RepositorioUsuario;

import java.util.List;

@Repository
public class UsuarioDAO {

    private final RepositorioUsuario repositorioUsuario;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UsuarioDAO(RepositorioUsuario repositorioUsuario, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.repositorioUsuario = repositorioUsuario;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insertarUsuario(Usuario u){
        repositorioUsuario.save(u);
    }

    public List<Usuario> getAllUsuario(){
        return  repositorioUsuario.findAll();
    }

    public Usuario buscarUsuario(String usuario, String contrasenia) throws Exception {
        MapSqlParameterSource param = new MapSqlParameterSource();
        String query = "SELECT id_usuario, usuario, contrasenia  FROM usuario WHERE usuario = :usuario AND contrasenia = :contrasenia";
        param.addValue("usuario", usuario);
        param.addValue("contrasenia", contrasenia);

        try {
            return namedParameterJdbcTemplate.queryForObject(query, param, (resultSet, rowNum) -> {
                Usuario user = new Usuario();
                user.setIdUsuario(resultSet.getLong("id_usuario"));
                user.setNombre(resultSet.getString("usuario"));
                user.setContrasenia(resultSet.getString("contrasenia"));
                // Completa la asignación de otras propiedades si es necesario
                return user;
            });
        } catch (Exception e ) {
            throw new Exception("Usuario no encontrado");
        }
    }


    public void eliminarUsuario(long idUsuario){
        repositorioUsuario.deleteById(idUsuario);
    }

    public Usuario actualizarUsuario(Usuario u){
        return repositorioUsuario.save(u);
    }

}

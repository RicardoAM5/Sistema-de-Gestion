package org.utl.donGalleto.DAO;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Galleta;
import org.utl.donGalleto.Model.GalletaNombreCantidad;
import org.utl.donGalleto.Repositorio.RepositorioGalleta;

import java.util.List;
import java.util.Optional;

//TEST
@Repository
public class GalletaDAO {

    private final RepositorioGalleta repositorioGalleta;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public GalletaDAO(RepositorioGalleta repositorioGalleta, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.repositorioGalleta = repositorioGalleta;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insertarGalleta(Galleta g) {
        repositorioGalleta.save(g);
    }

    public List<Galleta> getAllGalleta() {
        return repositorioGalleta.findAll();
    }

    public Optional<Galleta> buscarGalleta(long idGalleta) {
        return repositorioGalleta.findById(idGalleta);
    }

    public void eliminarGalleta(long idGalleta) {
        repositorioGalleta.deleteById(idGalleta);
    }

    public Galleta actualizarGalleta(Galleta g) {
        repositorioGalleta.save(g);
        return g;
    }

    public List<GalletaNombreCantidad> obtenerNombreYCantidad() throws Exception {
        try {
            String query = "SELECT nombre, cantidad FROM galleta;";
            return namedParameterJdbcTemplate.query(query, (resultSet, i) -> {
                GalletaNombreCantidad galleta = new GalletaNombreCantidad();
                galleta.setNombre(resultSet.getString("nombre"));
                galleta.setCantidad(resultSet.getString("cantidad"));
                return galleta;
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al obtener la información de la galleta");
        }
    }

    public String actualizarCantidadGalleta(String nombre, String cantidad) throws Exception {
        try {
            MapSqlParameterSource param = new MapSqlParameterSource();
            String query = "UPDATE  galleta SET cantidad = :cantidad WHERE nombre =:nombre";
            param.addValue("cantidad", cantidad);
            param.addValue("nombre", nombre);
            namedParameterJdbcTemplate.update(query, param);
            return "Datos actualizados";
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al actualizar la información de la galleta");
        }
    }


}

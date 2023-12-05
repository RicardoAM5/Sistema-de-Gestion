package org.utl.donGalleto.DAO;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Inventario;

import java.util.List;

@Repository
public class InventarioDAO {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public InventarioDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public List<Inventario> getAllInventario() throws Exception {
        try {
            String query = "SELECT nombre, cantidad FROM galleta;";
            return namedParameterJdbcTemplate.query(query, (resultSet, i) -> {
                Inventario galleta = new Inventario();
                galleta.setNombre(resultSet.getString("nombre"));
                galleta.setCantidad(resultSet.getString("cantidad"));
                return galleta;
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al obtener la información de la galleta");
        }
    }

    public String actualizarInventario(String nombre, String cantidad) throws Exception {
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

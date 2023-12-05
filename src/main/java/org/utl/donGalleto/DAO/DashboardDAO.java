package org.utl.donGalleto.DAO;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Dashboard;
import org.utl.donGalleto.Model.Inventario;

import java.util.List;

@Repository
public class DashboardDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DashboardDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }



    public List<Dashboard> getAll() throws Exception {
        try {
            String query = "SELECT DATE(fecha) AS fecha, g.nombre AS nombre_galleta, SUM(v.cantidad) AS cantidad_vendida\n" +
                    "FROM venta v\n" +
                    "JOIN galleta g ON v.id_galleta = g.id_galleta\n" +
                    "GROUP BY DATE(fecha), g.nombre\n" +
                    "ORDER BY DATE(fecha), g.nombre;;";
            return namedParameterJdbcTemplate.query(query, (resultSet, i) -> {
                Dashboard dashboard = new Dashboard();
                dashboard.setNombreGalleta(resultSet.getString("nombre_galleta"));
                dashboard.setCantidadVendida(resultSet.getFloat("cantidad_vendida"));
                return dashboard;
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al obtener la información de las ventas");
        }
    }


    public List<Dashboard> ventasFecha(String filtro ) throws Exception {
        if (filtro.equals("dia")) {
            try {
                String query = "SELECT g.nombre AS nombre_galleta, SUM(v.cantidad) AS cantidad_vendida\n" +
                        "FROM venta v\n" +
                        "JOIN galleta g ON v.id_galleta = g.id_galleta\n" +
                        "WHERE DATE(fecha) = CURRENT_DATE \n" +
                        "GROUP BY  g.nombre;";
                return namedParameterJdbcTemplate.query(query, (resultSet, i) -> {
                    Dashboard dashboard = new Dashboard();
                    dashboard.setNombreGalleta(resultSet.getString("nombre_galleta"));
                    dashboard.setCantidadVendida(resultSet.getFloat("cantidad_vendida"));
                    return dashboard;
                });
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("Error al obtener la información de las ventas");
            }
        }
        if(filtro.equals("semana")){
            try {
                String query = "select g.nombre AS nombre_galleta, \n" +
                        "       SUM(v.cantidad) AS cantidad_vendida\n" +
                        "FROM venta v\n" +
                        "JOIN galleta g ON v.id_galleta = g.id_galleta\n" +
                        "WHERE EXTRACT(WEEK FROM fecha) = EXTRACT(WEEK FROM CURRENT_DATE) -- Filtra las ventas de la semana actual\n" +
                        "GROUP BY  g.nombre;";
                return namedParameterJdbcTemplate.query(query, (resultSet, i) -> {
                    Dashboard dashboard = new Dashboard();
                    dashboard.setNombreGalleta(resultSet.getString("nombre_galleta"));
                    dashboard.setCantidadVendida(resultSet.getFloat("cantidad_vendida"));
                    return dashboard;
                });
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("Error al obtener la información de las ventas");
            }

        }
        if (filtro.equals("mes")){
            try {
                String query = "SELECT g.nombre AS nombre_galleta, \n" +
                        "       SUM(v.cantidad) AS cantidad_vendida\n" +
                        "FROM venta v\n" +
                        "JOIN galleta g ON v.id_galleta = g.id_galleta\n" +
                        "WHERE EXTRACT(MONTH FROM fecha) = EXTRACT(MONTH FROM CURRENT_DATE) -- Filtra las ventas del mes actual\n" +
                        "GROUP BY g.nombre";
                return namedParameterJdbcTemplate.query(query, (resultSet, i) -> {
                    Dashboard dashboard = new Dashboard();
                    dashboard.setNombreGalleta(resultSet.getString("nombre_galleta"));
                    dashboard.setCantidadVendida(resultSet.getFloat("cantidad_vendida"));
                    return dashboard;
                });
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("Error al obtener la información de las ventas");
            }
        }else{
            throw new Exception("Filtro incorrecto");
        }
    }

}

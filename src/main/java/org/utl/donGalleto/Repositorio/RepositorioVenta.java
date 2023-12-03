package org.utl.donGalleto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Venta;

import java.util.Optional;

@Repository
public interface RepositorioVenta extends JpaRepository<Venta,Long> {
}

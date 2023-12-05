package org.utl.donGalleto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utl.donGalleto.Model.Inventario;

public interface RepositorioInventario extends JpaRepository<Inventario,Long> {
}

package org.utl.donGalleto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
}

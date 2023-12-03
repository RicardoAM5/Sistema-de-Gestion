package org.utl.donGalleto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.MateriaPrima;

@Repository
public interface RepositorioMateriaPrima extends JpaRepository<MateriaPrima,Long> {
}

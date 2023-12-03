package org.utl.donGalleto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utl.donGalleto.Model.Galleta;

@Repository
public interface RepositorioGalleta extends JpaRepository<Galleta,Long> {



}

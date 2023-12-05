package org.utl.donGalleto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utl.donGalleto.Model.Crud;

public interface RepositorioCrud extends JpaRepository<Crud,Long> {
}

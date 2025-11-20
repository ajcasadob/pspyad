package com.salesianostrianacasadobayon.biblioteca.repository;

import com.salesianostrianacasadobayon.biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}

package com.salesianostriana.bookclub.repository;

import com.salesianostriana.bookclub.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}

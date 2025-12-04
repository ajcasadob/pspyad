package com.salesianostrianaejemplos.asociaciones.repository;

import com.salesianostrianaejemplos.asociaciones.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje,Long> {
}

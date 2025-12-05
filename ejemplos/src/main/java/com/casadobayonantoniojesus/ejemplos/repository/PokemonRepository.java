package com.casadobayonantoniojesus.ejemplos.repository;

import com.casadobayonantoniojesus.ejemplos.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}

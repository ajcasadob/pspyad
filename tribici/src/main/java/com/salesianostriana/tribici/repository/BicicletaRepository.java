package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicleta,Long> {
}

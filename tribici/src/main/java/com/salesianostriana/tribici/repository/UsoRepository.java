package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.Uso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsoRepository extends JpaRepository<Uso, Long> {
}

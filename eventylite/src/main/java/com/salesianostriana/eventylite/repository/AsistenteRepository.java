package com.salesianostriana.eventylite.repository;

import com.salesianostriana.eventylite.model.Asistente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenteRepository extends JpaRepository<Asistente,Long> {
}

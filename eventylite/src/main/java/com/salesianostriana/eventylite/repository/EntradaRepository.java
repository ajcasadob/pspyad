package com.salesianostriana.eventylite.repository;

import com.salesianostriana.eventylite.model.Entrada;
import com.salesianostriana.eventylite.model.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada,Long> {

    @EntityGraph(attributePaths = {"evento","asistente"})
    List<Entrada> findByAsistente_IdAndEstado(Long id, Estado estado);

    @EntityGraph(attributePaths = {"evento","asistente"})
    @Query("select e from Entrada e where e.evento.id =?1")
    Page<Entrada> findByEvento_id(Long id, Pageable pageable);
}

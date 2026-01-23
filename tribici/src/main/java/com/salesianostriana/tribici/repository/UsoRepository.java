package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.Uso;
import com.salesianostriana.tribici.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsoRepository extends JpaRepository<Uso, Long> {

    @Query("""
            select u 
            from Uso u 
            where u.usuario = ?1
              and u.fechaFin is null 
            order by u.fechaInicio DESC
            """)
    Optional<Uso> findByUsuarioOrderByFechaInicioDesc(Usuario usuario);
}
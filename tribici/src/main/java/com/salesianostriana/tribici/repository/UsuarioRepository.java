package com.salesianostriana.tribici.repository;

import com.salesianostriana.tribici.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("select u from Usuario u where u.numTarjeta = ?1 and u.pin = ?2")
    Optional<Usuario> findByNumTarjetaAndPin(String numTarjeta, String pin);
}

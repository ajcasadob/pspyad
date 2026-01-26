package com.salesianostriana.ejemploejercicio.repository;

import com.salesianostriana.ejemploejercicio.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>, JpaSpecificationExecutor<Usuario> {
}

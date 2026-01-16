package com.salesianostriana.bookclub.repository;

import com.salesianostriana.bookclub.model.Estado;
import com.salesianostriana.bookclub.model.Prestamo;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo,Long> {


    Page<Prestamo> findByEstado(Estado estado, Pageable pageable);
}

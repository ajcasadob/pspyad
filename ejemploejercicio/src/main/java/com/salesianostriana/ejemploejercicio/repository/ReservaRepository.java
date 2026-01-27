package com.salesianostriana.ejemploejercicio.repository;

import com.salesianostriana.ejemploejercicio.model.EstadoReserva;
import com.salesianostriana.ejemploejercicio.model.Reserva;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>, JpaSpecificationExecutor<Reserva> {


    List<Reserva> findBySalaIdAndFechaAndEstadoAndHoraInicioLessThanAndHoraFinGreaterThan(
            Long salaId,
            LocalDate fecha,
            EstadoReserva estado,
            LocalTime horaFin,
            LocalTime horaInicio
    );

}

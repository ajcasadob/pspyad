package com.salesianostrianadam.dto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AlumnoMapper {


    public AlumnoDTO toDto(Alumno alumno) {
        if (alumno == null) return null;

        return new AlumnoDTO(

                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellido1(),
                alumno.getApellido2(),
                alumno.getEmail(),
                alumno.getTelefono(),
                alumno.getCurso(),
                alumno.getDireccion()
        );
    }


    public Alumno toEntity (AlumnoDTO dto){
        if (dto == null) return null;


        return Alumno.builder()
                .id(dto.id())
                .email(dto.email())
                .curso(dto.curso())
                .apellido1(dto.apellidos1())
                .apellido2(dto.apellido2())
                .direccion(dto.direccion())
                .nombre(dto.nombre())
                .telefono(dto.telefono())
                .build();
    }



}

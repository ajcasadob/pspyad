package com.salesianostrianadam.dto2;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "nombre", target = "nombre")
    ProductoDTO toDto (Producto producto);

    @InheritConfiguration
    Producto toEntity (ProductoDTO dto);
}

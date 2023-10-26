package com.ecommerce.core.infraestructure.dto.mapper;

import com.ecommerce.core.domain.Articulo;
import com.ecommerce.core.infraestructure.dto.ArticuloDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticuloDtoMapper {
    ArticuloDtoMapper INSTANCE = Mappers.getMapper(ArticuloDtoMapper.class);

    // Mapeo de atributos desde Articulo de dominio a ArticuloDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precio", target = "precio")
    @Mapping(source = "marca", target = "marca")
    @Mapping(source = "modelo", target = "modelo")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")
    ArticuloDto toArticuloDTO(Articulo articulo);
    Iterable<Articulo> iterableToArticuloDTO(Iterable<ArticuloDto> articulos);

    // Mapeo de atributos desde ArticuloDTO a Articulo de dominio
    @InheritInverseConfiguration
    Articulo toArticulo(ArticuloDto articuloDto);
}


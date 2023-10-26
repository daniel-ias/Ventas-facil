package com.ecommerce.core.infraestructure.dto.mapper;

import com.ecommerce.core.domain.Servicio;
import com.ecommerce.core.infraestructure.dto.ServicioDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServicioDtoMapper {
    ServicioDtoMapper INSTANCE = Mappers.getMapper(ServicioDtoMapper.class);

    // Mapeo de atributos desde Servicio de dominio a ServicioDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "codigo", target = "codigo")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "precio", target = "precio")
    @Mapping(source = "unidadMedida", target = "unidadMedida")
    @Mapping(source = "frecuencia", target = "frecuencia")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")
    ServicioDto toServicioDTO(Servicio servicio);

    Iterable<Servicio> iterableToServicioDTO(Iterable<ServicioDto> servicios);

    // Mapeo de atributos desde ServicioDTO a Servicio de dominio
    @InheritInverseConfiguration
    Servicio toServicio(ServicioDto servicioDto);
}

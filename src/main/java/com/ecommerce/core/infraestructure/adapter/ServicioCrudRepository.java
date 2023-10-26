package com.ecommerce.core.infraestructure.adapter;

import com.ecommerce.core.infraestructure.dto.ServicioDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServicioCrudRepository extends CrudRepository<ServicioDto, Integer> {

    List<ServicioDto> findByCodigo(String codigo);

    List<ServicioDto> findByNombre(String nombre);

    List<ServicioDto> findByDescripcion(String descripcion);
}

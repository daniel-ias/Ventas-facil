package com.ecommerce.core.infraestructure.adapter;

import com.ecommerce.core.infraestructure.dto.ArticuloDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticuloCrudRepository extends CrudRepository<ArticuloDto, Integer> {

    List<ArticuloDto> findByCodigo(String codigo);

    List<ArticuloDto> findByNombre(String nombre);

    List<ArticuloDto> findByDescripcion(String descripcion);
}

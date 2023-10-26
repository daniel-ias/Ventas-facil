package com.ecommerce.core.application.repository;

import com.ecommerce.core.domain.Articulo;

import java.util.List;

public interface ArticuloRepository {

    Iterable<Articulo> listaArticulos();

    List<Articulo> findById(Integer id);

    List<Articulo> findByCodigo(String codigo);

    List<Articulo> findByNombre(String nombre);

    List<Articulo> findByDescripcion(String descripcion);

    Articulo saveArticulo(Articulo articulo);

    Articulo actualizarArticulo(Articulo articulo);

    void deleteByIdArticulo(Integer id);
}
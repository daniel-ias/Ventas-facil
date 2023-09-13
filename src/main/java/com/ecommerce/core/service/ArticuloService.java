package com.ecommerce.core.service;

import com.ecommerce.core.model.Articulo;
import com.ecommerce.core.model.Servicio;

import java.util.List;

public interface ArticuloService {

    //Articulos:

    //Consulta los articulos
    List<Articulo> listaArticulos();

    //Consultar por código, nombre y descripción.
    List<Articulo> findByCodigo(String codigo);

    List<Articulo> findByNombre(String nombre);

    List<Articulo> findByDescripcion(String descripcion);

    //Guardar los articulos (Actualizar)
    Articulo saveArticulo(Articulo articulo);

    //Editar los articulos
    Articulo actualizarArticulo(Articulo articulo);

    //Eliminar los articulos
    void deleteByIdArticulo(Integer id);
}

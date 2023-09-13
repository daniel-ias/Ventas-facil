package com.ecommerce.core.service;

import com.ecommerce.core.model.Servicio;

import java.util.List;

public interface ServicioService {

    //Servicios:

    //Consulta los articulos
    List<Servicio> listaServicios();

    //Consultar por código, nombre y descripción.
    List<Servicio> findServicioByCodigo(String codigo);

    List<Servicio> findServicioByNombre(String nombre);

    List<Servicio> findServicioByDescripcion(String descripcion);

    //Guardar los articulos (Actualizar)
    Servicio saveServicio(Servicio servicio);

    //Editar los articulos
    Servicio actualizarServicio(Servicio servicio);

    //Eliminar los articulos
    void deleteByIdServicio(Integer id);
}

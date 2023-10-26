package com.ecommerce.core.application.repository;

import com.ecommerce.core.domain.Servicio;

import java.util.List;

public interface ServicioRepository {
    Iterable<Servicio> listaServicios();

    List<Servicio> findById(Integer id);

    List<Servicio> findByCodigo(String codigo);

    List<Servicio> findByNombre(String nombre);

    List<Servicio> findByDescripcion(String descripcion);

    Servicio saveServicio(Servicio servicio);

    Servicio actualizarServicio(Servicio servicio);

    void deleteByIdServicio(Integer id);
}

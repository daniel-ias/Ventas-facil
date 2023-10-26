package com.ecommerce.core.application.service;

import com.ecommerce.core.application.repository.ServicioRepository;
import com.ecommerce.core.domain.Servicio;

import java.util.List;

public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public Iterable<Servicio> listaServicios() {
        return servicioRepository.listaServicios();
    }

    public List<Servicio> findById(Integer id) {
        return servicioRepository.findById(id);
    }

    public List<Servicio> findByCodigo(String codigo) {
        return servicioRepository.findByCodigo(codigo);
    }

    public List<Servicio> findByNombre(String nombre) {
        return servicioRepository.findByNombre(nombre);
    }

    public List<Servicio> findByDescripcion(String descripcion) {
        return servicioRepository.findByDescripcion(descripcion);
    }

    public Servicio saveServicio(Servicio servicio) {
        return servicioRepository.saveServicio(servicio);
    }

    public Servicio actualizarServicio(Servicio servicio) {
        return servicioRepository.actualizarServicio(servicio);
    }

    public void deleteByIdServicio(Integer id) {
        servicioRepository.deleteByIdServicio(id);
    }
}

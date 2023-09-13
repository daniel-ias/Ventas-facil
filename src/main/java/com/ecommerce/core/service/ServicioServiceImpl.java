package com.ecommerce.core.service;

import com.ecommerce.core.exception.MyException;
import com.ecommerce.core.model.Servicio;
import com.ecommerce.core.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService{

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> listaServicios() {
        try {
            return (List<Servicio>) servicioRepository.findAll();
        } catch (Exception e) {
            throw new MyException("Error al obtener la lista de servicios", e);
        }
    }

    @Override
    public List<Servicio> findServicioByCodigo(String codigo) {
        try {
            return servicioRepository.findServicioByCodigo(codigo);
        } catch (Exception e) {
            throw new MyException("Error al buscar servicios por código", e);
        }
    }

    @Override
    public List<Servicio> findServicioByNombre(String nombre) {
        try {
            return servicioRepository.findServicioByNombre(nombre);
        } catch (Exception e) {
            throw new MyException("Error al buscar servicios por nombre", e);
        }
    }

    @Override
    public List<Servicio> findServicioByDescripcion(String descripcion) {
        try {
            return servicioRepository.findServicioByDescripcion(descripcion);
        } catch (Exception e) {
            throw new MyException("Error al buscar servicios por descripción", e);
        }
    }

    @Override
    public Servicio saveServicio(Servicio servicio) {
        try {
            return servicioRepository.save(servicio);
        } catch (Exception e) {
            throw new MyException("Error al guardar el servicio", e);
        }
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio) {
        try {
            return servicioRepository.save(servicio);
        } catch (Exception e) {
            throw new MyException("Error al actualizar el servicio", e);
        }
    }

    @Override
    public void deleteByIdServicio(Integer id) {
        try {
            servicioRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException("Error al eliminar el servicio", e);
        }
    }
}

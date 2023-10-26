package com.ecommerce.core.infraestructure.adapter;

import com.ecommerce.core.application.repository.ServicioRepository;
import com.ecommerce.core.domain.Servicio;
import com.ecommerce.core.infraestructure.dto.ServicioDto;
import com.ecommerce.core.infraestructure.exception.MyException;
import com.ecommerce.core.infraestructure.dto.mapper.ServicioDtoMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ServicioRepositoryImpl implements ServicioRepository{

    private final ServicioCrudRepository servicioCrudRepository;

    private final ServicioDtoMapper servicioDtoMapper;

    public ServicioRepositoryImpl(ServicioCrudRepository servicioCrudRepository, ServicioDtoMapper servicioDtoMapper) {
        this.servicioCrudRepository = servicioCrudRepository;
        this.servicioDtoMapper = servicioDtoMapper;
    }

    @Override
    public Iterable<Servicio> listaServicios() {
        try {
            return servicioDtoMapper.iterableToServicioDTO(servicioCrudRepository.findAll());
        } catch (Exception e) {
            throw new MyException("Error al obtener la lista de servicios", e);
        }
    }

    @Override
    public List<Servicio> findById(Integer id) {
        try {
            return (List<Servicio>) servicioDtoMapper.iterableToServicioDTO(servicioCrudRepository.findAllById(Collections.singleton(id)));
        } catch (Exception e) {
            throw new MyException("Error al buscar servicios por id", e);
        }
    }

    @Override
    public List<Servicio> findByCodigo(String codigo) {
        try {
            return (List<Servicio>) servicioDtoMapper.iterableToServicioDTO(servicioCrudRepository.findByCodigo(codigo));
        } catch (Exception e) {
            throw new MyException("Error al buscar servicios por código", e);
        }
    }

    @Override
    public List<Servicio> findByNombre(String nombre) {
        try {
            return (List<Servicio>) servicioDtoMapper.iterableToServicioDTO(servicioCrudRepository.findByNombre(nombre));
        } catch (Exception e) {
            throw new MyException("Error al buscar servicios por nombre", e);
        }
    }

    @Override
    public List<Servicio> findByDescripcion(String descripcion) {
        try {
            return (List<Servicio>) servicioDtoMapper.iterableToServicioDTO(servicioCrudRepository.findByDescripcion(descripcion));
        } catch (Exception e) {
            throw new MyException("Error al buscar servicios por descripción", e);
        }
    }

    @Override
    public Servicio saveServicio(Servicio servicio) {
        try {
            ServicioDto servicioDto = servicioCrudRepository.save(servicioDtoMapper.toServicioDTO(servicio));
            return servicioDtoMapper.toServicio(servicioDto);
        } catch (Exception e) {
            throw new MyException("Error al guardar el servicio", e);
        }
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio) {
        try {
            if (!servicioCrudRepository.existsById(servicio.getId())) {
                Exception e = new Exception();
                throw new MyException("El artículo con ID " + servicio.getId() + " no existe.", e);
            }
            ServicioDto servicioDto = servicioCrudRepository.save(servicioDtoMapper.toServicioDTO(servicio));
            return servicioDtoMapper.toServicio(servicioDto);
        } catch (Exception e) {
            throw new MyException("Error al actualizar el servicio", e);
        }
    }

    @Override
    public void deleteByIdServicio(Integer id) {
        try {
            servicioCrudRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException("Error al eliminar el servicio", e);
        }
    }
}

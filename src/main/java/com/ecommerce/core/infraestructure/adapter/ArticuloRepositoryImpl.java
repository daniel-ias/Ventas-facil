package com.ecommerce.core.infraestructure.adapter;

import com.ecommerce.core.application.repository.ArticuloRepository;
import com.ecommerce.core.domain.Articulo;
import com.ecommerce.core.infraestructure.dto.ArticuloDto;
import com.ecommerce.core.infraestructure.dto.mapper.ArticuloDtoMapper;
import com.ecommerce.core.infraestructure.exception.MyException;
import java.util.Collections;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloRepositoryImpl implements  ArticuloRepository{

    private final ArticuloCrudRepository articuloCrudRepository;

    private final ArticuloDtoMapper articuloDtoMapper;


    public ArticuloRepositoryImpl(ArticuloCrudRepository articuloCrudRepository, ArticuloDtoMapper articuloDtoMapper) {
        this.articuloCrudRepository = articuloCrudRepository;
        this.articuloDtoMapper = articuloDtoMapper;
    }

    @Override
    public Iterable<Articulo> listaArticulos() {
        try {
            return articuloDtoMapper.iterableToArticuloDTO(articuloCrudRepository.findAll());
        } catch (Exception e) {
            throw new MyException("Error al obtener la lista de artículos", e);
        }
    }

    @Override
    public List<Articulo> findById(Integer id) {
        try {
            return (List<Articulo>) articuloDtoMapper.iterableToArticuloDTO(articuloCrudRepository.findAllById(Collections.singleton(id)));
        } catch (Exception e) {
            throw new MyException("Error al obtener el articulo", e);
        }
    }

    @Override
    public List<Articulo> findByCodigo(String codigo) {
        try {
            return (List<Articulo>) articuloDtoMapper.iterableToArticuloDTO(articuloCrudRepository.findByCodigo(codigo));
        } catch (Exception e) {
            throw new MyException("Error al buscar artículos por código", e);
        }
    }

    @Override
    public List<Articulo> findByNombre(String nombre) {
        try {
            return (List<Articulo>) articuloDtoMapper.iterableToArticuloDTO(articuloCrudRepository.findByNombre(nombre));
        } catch (Exception e) {
            throw new MyException("Error al buscar artículos por nombre", e);
        }
    }

    @Override
    public List<Articulo> findByDescripcion(String descripcion) {
        try {
            return (List<Articulo>) articuloDtoMapper.iterableToArticuloDTO(articuloCrudRepository.findByDescripcion(descripcion));
        } catch (Exception e) {
            throw new MyException("Error al buscar artículos por descripción", e);
        }
    }

    @Override
    public Articulo saveArticulo(Articulo articulo) {
        try {
            ArticuloDto articuloDto = articuloCrudRepository.save(articuloDtoMapper.toArticuloDTO(articulo));
            return articuloDtoMapper.toArticulo(articuloDto);
        } catch (Exception e) {
            throw new MyException("Error al guardar el artículo", e);
        }
    }

    @Override
    public Articulo actualizarArticulo(Articulo articulo) {
        try {
            if (!articuloCrudRepository.existsById(articulo.getId())) {
                Exception e = new Exception();
                throw new MyException("El artículo con ID " + articulo.getId() + " no existe.", e);
            }
            ArticuloDto articuloDto = articuloCrudRepository.save(articuloDtoMapper.toArticuloDTO(articulo));
            return articuloDtoMapper.toArticulo(articuloDto);
        } catch (Exception e) {
            throw new MyException("Error al actualizar el artículo", e);
        }
    }

    @Override
    public void deleteByIdArticulo(Integer id) {
        try {
            articuloCrudRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException("Error al eliminar el artículo", e);
        }
    }
}

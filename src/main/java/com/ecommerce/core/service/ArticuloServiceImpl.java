package com.ecommerce.core.service;

import com.ecommerce.core.exception.MyException;
import com.ecommerce.core.model.Articulo;
import com.ecommerce.core.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServiceImpl implements ArticuloService{

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> listaArticulos() {
        try {
            return (List<Articulo>) articuloRepository.findAll();
        } catch (Exception e) {
            throw new MyException("Error al obtener la lista de artículos", e);
        }
    }

    @Override
    public List<Articulo> findByCodigo(String codigo) {
        try {
            return articuloRepository.findByCodigo(codigo);
        } catch (Exception e) {
            throw new MyException("Error al buscar artículos por código", e);
        }
    }

    @Override
    public List<Articulo> findByNombre(String nombre) {
        try {
            return articuloRepository.findByNombre(nombre);
        } catch (Exception e) {
            throw new MyException("Error al buscar artículos por nombre", e);
        }
    }

    @Override
    public List<Articulo> findByDescripcion(String descripcion) {
        try {
            return articuloRepository.findByDescripcion(descripcion);
        } catch (Exception e) {
            throw new MyException("Error al buscar artículos por descripción", e);
        }
    }

    @Override
    public Articulo saveArticulo(Articulo articulo) {
        try {
            return articuloRepository.save(articulo);
        } catch (Exception e) {
            throw new MyException("Error al guardar el artículo", e);
        }
    }

    @Override
    public Articulo actualizarArticulo(Articulo articulo) {
        try {
            return articuloRepository.save(articulo);
        } catch (Exception e) {
            throw new MyException("Error al actualizar el artículo", e);
        }
    }

    @Override
    public void deleteByIdArticulo(Integer id) {
        try {
            articuloRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyException("Error al eliminar el artículo", e);
        }
    }
}

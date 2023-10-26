package com.ecommerce.core.application.service;

import com.ecommerce.core.application.repository.ArticuloRepository;
import com.ecommerce.core.domain.Articulo;

import java.util.List;

public class ArticuloService {

    private final ArticuloRepository articuloRepository;


    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public Iterable<Articulo> listaArticulos() {
        return articuloRepository.listaArticulos();
    }

    public List<Articulo> findById(Integer id) {
        return articuloRepository.findById(id);
    }

    public List<Articulo> findByCodigo(String codigo) {
        return articuloRepository.findByCodigo(codigo);
    }

    public List<Articulo> findByNombre(String nombre) {
        return articuloRepository.findByNombre(nombre);
    }

    public List<Articulo> findByDescripcion(String descripcion) {
        return articuloRepository.findByDescripcion(descripcion);
    }

    public Articulo saveArticulo(Articulo articulo) {
        return articuloRepository.saveArticulo(articulo);
    }

    public Articulo actualizarArticulo(Articulo articulo) {
        return articuloRepository.actualizarArticulo(articulo);
    }

    public void deleteByIdArticulo(Integer id) {
        articuloRepository.deleteByIdArticulo(id);
    }
}

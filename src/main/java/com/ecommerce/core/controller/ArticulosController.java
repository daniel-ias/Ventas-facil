package com.ecommerce.core.controller;

import com.ecommerce.core.model.Articulo;
import com.ecommerce.core.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/catalogo")
public class ArticulosController {
    private ArticuloService articuloService;

    @Autowired
    public void setArticuloService(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/articulos/listar")
    public ResponseEntity<List<Articulo>> listaArticulos() {
        List<Articulo> articulo = articuloService.listaArticulos();
        return new ResponseEntity<List<Articulo>>(articulo, HttpStatus.OK);
    }

    @GetMapping("/articulos/consultaCodigo/{codigo}")
    public ResponseEntity<List<Articulo>> findByCodigo(@PathVariable String codigo) {
        return new ResponseEntity<List<Articulo>>(articuloService.findByCodigo(codigo), HttpStatus.OK);
    }

    @GetMapping("/articulos/consultaNombre/{nombre}")
    public ResponseEntity<List<Articulo>> findByNombre(@PathVariable String nombre) {
        return new ResponseEntity<List<Articulo>>(articuloService.findByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/articulos/consultaDescripcion/{descripcion}")
    public ResponseEntity<List<Articulo>> findByDescripcion(@PathVariable String descripcion) {
        return new ResponseEntity<List<Articulo>>(articuloService.findByDescripcion(descripcion), HttpStatus.OK);
    }

    @PostMapping("/articulos/actualizar/{id}")
    public ResponseEntity<Articulo> actualizarArticulo(@PathVariable Integer id,
                                                       @RequestBody Articulo articulo) {
        return new ResponseEntity<>(articuloService.actualizarArticulo(articulo), HttpStatus.ACCEPTED);
    }

    @PostMapping("/articulos/guardar")
    public ResponseEntity<Articulo> guardarArticulo(@RequestBody Articulo articulo) {
        return new ResponseEntity<>(articuloService.saveArticulo(articulo), HttpStatus.CREATED);
    }

    @DeleteMapping("/articulos/eliminar/{id}")
    public void eliminarArticulo(@PathVariable Integer id) {
        articuloService.deleteByIdArticulo(id);
    }
}

package com.ecommerce.core.infraestructure.controller;

import com.ecommerce.core.application.service.ArticuloService;
import com.ecommerce.core.domain.Articulo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
@CrossOrigin(origins = "*")
public class ArticulosController {
    private final ArticuloService articuloService;

    public ArticulosController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/articulos/listar")
    public ResponseEntity<Iterable<Articulo>> listaArticulos() {
        return new ResponseEntity<>(articuloService.listaArticulos(), HttpStatus.OK);
    }

    @GetMapping("/articulos/listarId/{id}")
    public ResponseEntity<List<Articulo>> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(articuloService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/articulos/consultaCodigo/{codigo}")
    public ResponseEntity<List<Articulo>> findByCodigo(@PathVariable String codigo) {
        return new ResponseEntity<>(articuloService.findByCodigo(codigo), HttpStatus.OK);
    }

    @GetMapping("/articulos/consultaNombre/{nombre}")
    public ResponseEntity<List<Articulo>> findByNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(articuloService.findByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/articulos/consultaDescripcion/{descripcion}")
    public ResponseEntity<List<Articulo>> findByDescripcion(@PathVariable String descripcion) {
        return new ResponseEntity<>(articuloService.findByDescripcion(descripcion), HttpStatus.OK);
    }

    @PostMapping("/articulos/guardar")
    public ResponseEntity<Articulo> guardarArticulo(@RequestBody Articulo articulo) {
        return new ResponseEntity<>(articuloService.saveArticulo(articulo), HttpStatus.CREATED);
    }

    @PutMapping("/articulos/actualizar/{id}")
    public ResponseEntity<Articulo> actualizarArticulo(@PathVariable Integer id,
                                                       @RequestBody Articulo articulo) {
        return new ResponseEntity<>(articuloService.actualizarArticulo(articulo), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/articulos/eliminar/{id}")
    public void eliminarArticulo(@PathVariable Integer id) {
        articuloService.deleteByIdArticulo(id);
    }
}

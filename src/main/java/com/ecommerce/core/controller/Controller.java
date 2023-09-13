package com.ecommerce.core.controller;

import com.ecommerce.core.model.Articulo;
import com.ecommerce.core.model.Servicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private List<Articulo> articulos = new ArrayList<>();
    private List<Servicio> servicios = new ArrayList<>();

    //Articulos:

    @PostMapping("/articulo")
    public ResponseEntity<String> agregarArticulo(@RequestBody Articulo articulo) {
        articulos.add(articulo);
        return ResponseEntity.ok("Artículo agregado con éxito.");
    }

    @GetMapping("/articulos")
    public List<Articulo> obtenerArticulos() {
        return articulos;
    }

    //Servicios:

    @PostMapping("/servicio")
    public ResponseEntity<String> agregarServicio(@RequestBody Servicio servicio) {
        servicios.add(servicio);
        return ResponseEntity.ok("Servicio agregado con éxito.");
    }

    @GetMapping("/servicios")
    public List<Servicio> obtenerServicios() {
        return servicios;
    }
}

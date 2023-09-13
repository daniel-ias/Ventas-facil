package com.ecommerce.core.controller;

import com.ecommerce.core.model.Servicio;
import com.ecommerce.core.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/servicios")
public class ServiciosController {

    private ServicioService servicioService;

    @Autowired
    public void setServicioRepository(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Servicio>> listaServicios() {
        List<Servicio> servicios = servicioService.listaServicios();
        return new ResponseEntity<List<Servicio>>(servicios, HttpStatus.OK);
    }

    @GetMapping("/consultaCodigo/{codigo}")
    public ResponseEntity<List<Servicio>> findServicioByCodigo(@PathVariable String codigo) {
        return new ResponseEntity<List<Servicio>>(servicioService.findServicioByCodigo(codigo), HttpStatus.OK);
    }

    @GetMapping("consultaNombre/{nombre}")
    public ResponseEntity<List<Servicio>> findServicioByNombre(@PathVariable String nombre) {
        return new ResponseEntity<List<Servicio>>(servicioService.findServicioByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("consultaDescripcion/{descripcion}")
    public ResponseEntity<List<Servicio>> findServicioByDescripcion(@PathVariable String descripcion) {
        return new ResponseEntity<List<Servicio>>(servicioService.findServicioByDescripcion(descripcion), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Servicio> guardarServicio(@RequestBody Servicio servicio) {
        return new ResponseEntity<>(servicioService.saveServicio(servicio), HttpStatus.CREATED);
    }

    @PostMapping("actualizar/{id}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable Integer id,
                                                       @RequestBody Servicio servicio) {
        return new ResponseEntity<>(servicioService.actualizarServicio(servicio), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("eliminar/{id}")
    public void deleteByIdServicio(@PathVariable Integer id) {
        servicioService.deleteByIdServicio(id);
    }
}

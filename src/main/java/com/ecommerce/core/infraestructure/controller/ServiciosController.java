package com.ecommerce.core.infraestructure.controller;

import com.ecommerce.core.application.service.ServicioService;
import com.ecommerce.core.domain.Servicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "*")
public class ServiciosController {

    private ServicioService servicioService;

    public ServiciosController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Servicio>> listaServicios() {
        return new ResponseEntity<>(servicioService.listaServicios(), HttpStatus.OK);
    }

    @GetMapping("consultaId/{id}")
    public ResponseEntity<List<Servicio>> findServicioById(@PathVariable Integer id) {
        return new ResponseEntity<>(servicioService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/consultaCodigo/{codigo}")
    public ResponseEntity<List<Servicio>> findServicioByCodigo(@PathVariable String codigo) {
        return new ResponseEntity<>(servicioService.findByCodigo(codigo), HttpStatus.OK);
    }

    @GetMapping("consultaNombre/{nombre}")
    public ResponseEntity<List<Servicio>> findServicioByNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(servicioService.findByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("consultaDescripcion/{descripcion}")
    public ResponseEntity<List<Servicio>> findServicioByDescripcion(@PathVariable String descripcion) {
        return new ResponseEntity<>(servicioService.findByDescripcion(descripcion), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Servicio> guardarServicio(@RequestBody Servicio servicio) {
        return new ResponseEntity<>(servicioService.saveServicio(servicio), HttpStatus.CREATED);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable Integer id,
                                                       @RequestBody Servicio servicio) {
        return new ResponseEntity<>(servicioService.actualizarServicio(servicio), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("eliminar/{id}")
    public void deleteByIdServicio(@PathVariable Integer id) {
        servicioService.deleteByIdServicio(id);
    }
}

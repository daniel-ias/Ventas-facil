package com.ecommerce.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articulo {
    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String marca;
    private String modelo;
    private LocalDate fechaRegistro;

}

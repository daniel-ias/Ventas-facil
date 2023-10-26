package com.ecommerce.core.infraestructure.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "articulos")
@Data
public class ArticuloDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String marca;
    private String modelo;
    private LocalDate fechaRegistro;
}

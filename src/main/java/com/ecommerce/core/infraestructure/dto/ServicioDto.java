package com.ecommerce.core.infraestructure.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "servicios")
@Data
public class ServicioDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String unidadMedida;
    private Integer frecuencia;
    private LocalDate fechaRegistro;
}

package com.ecommerce.core.repository;

import com.ecommerce.core.model.Servicio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Integer> {

    @Query("SELECT a FROM Servicio a WHERE a.codigo = :codigo")
    List<Servicio> findServicioByCodigo(@Param("codigo") String codigo);

    @Query("SELECT a FROM Servicio a WHERE a.nombre LIKE %:nombre%")
    List<Servicio> findServicioByNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM Servicio a WHERE a.descripcion LIKE %:descripcion%")
    List<Servicio> findServicioByDescripcion(@Param("descripcion") String descripcion);
}

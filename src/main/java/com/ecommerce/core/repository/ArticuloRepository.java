package com.ecommerce.core.repository;

import com.ecommerce.core.model.Articulo;
import com.ecommerce.core.model.Servicio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Integer> {

    @Query("SELECT a FROM Articulo a WHERE a.codigo = :codigo")
    List<Articulo> findByCodigo(@Param("codigo") String codigo);

    @Query("SELECT a FROM Articulo a WHERE a.nombre LIKE %:nombre%")
    List<Articulo> findByNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM Articulo a WHERE a.descripcion LIKE %:descripcion%")
    List<Articulo> findByDescripcion(@Param("descripcion") String descripcion);
}
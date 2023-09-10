package com.application.api.rest.repository;

import com.application.api.rest.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    // ANOTACION QUERY PARA OBTENER RANGO DE PRECIO
    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN ?1 AND ?2")
    List<Producto> obtenerProductoPorRangoDePrecio(BigDecimal precioMin, BigDecimal precioMax);

}

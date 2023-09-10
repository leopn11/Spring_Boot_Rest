package com.application.api.rest.persistence;

import com.application.api.rest.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductoDAO {

    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    // METODO QUERY PARA OBTENER RANGO DE PRECIO
    List<Producto> obtenerProductoPorRangoDePrecio(BigDecimal precioMin , BigDecimal precioMax);

    void save(Producto producto);

    void deleteById(Long id);
}

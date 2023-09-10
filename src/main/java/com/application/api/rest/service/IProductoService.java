package com.application.api.rest.service;

import com.application.api.rest.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    List<Producto> obtenerProductoPorRangoDePrecio(BigDecimal precioMin , BigDecimal precioMax);

    void save(Producto producto);

    void deleteById(Long id);
}

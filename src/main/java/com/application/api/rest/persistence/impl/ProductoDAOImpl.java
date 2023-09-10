package com.application.api.rest.persistence.impl;

import com.application.api.rest.entities.Producto;
import com.application.api.rest.persistence.IProductoDAO;
import com.application.api.rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoDAOImpl implements IProductoDAO {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> obtenerProductoPorRangoDePrecio(BigDecimal precioMin, BigDecimal precioMax) {
        return productoRepository.obtenerProductoPorRangoDePrecio(precioMin, precioMax);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}

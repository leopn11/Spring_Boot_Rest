package com.application.api.rest.service.Impl;

import com.application.api.rest.entities.Producto;
import com.application.api.rest.persistence.IProductoDAO;
import com.application.api.rest.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;


    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoDAO.findById(id);
    }

    @Override
    public List<Producto> obtenerProductoPorRangoDePrecio(BigDecimal precioMin, BigDecimal precioMax) {
        return productoDAO.obtenerProductoPorRangoDePrecio(precioMin, precioMax);
    }

    @Override
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoDAO.deleteById(id);
    }
}

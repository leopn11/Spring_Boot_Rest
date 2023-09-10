package com.application.api.rest.service;

import com.application.api.rest.entities.Fabricante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IFabricanteService {
    List<Fabricante> findAll();

    Optional<Fabricante> findById(Long id);

    void save(Fabricante fabricante);

    void deleteById(Long id);
}

package com.application.api.rest.persistence;

import com.application.api.rest.entities.Fabricante;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface IFabricanteDAO {

    List<Fabricante> findAll();

    Optional<Fabricante> findById(Long id);

    void save(Fabricante fabricante);

    void deleteById(Long id);


}

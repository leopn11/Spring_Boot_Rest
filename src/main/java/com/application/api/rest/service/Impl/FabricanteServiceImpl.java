package com.application.api.rest.service.Impl;

import com.application.api.rest.entities.Fabricante;
import com.application.api.rest.persistence.IFabricanteDAO;
import com.application.api.rest.service.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteServiceImpl implements IFabricanteService {

    @Autowired
    private IFabricanteDAO fabricanteDAO;

    @Override
    public List<Fabricante> findAll() {
        return fabricanteDAO.findAll();
    }

    @Override
    public Optional<Fabricante> findById(Long id) {
        return fabricanteDAO.findById(id);
    }

    @Override
    public void save(Fabricante fabricante) {
        fabricanteDAO.save(fabricante);
    }

    @Override
    public void deleteById(Long id) {
        fabricanteDAO.deleteById(id);
    }
}

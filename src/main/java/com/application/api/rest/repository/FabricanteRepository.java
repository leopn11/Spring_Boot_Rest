package com.application.api.rest.repository;

import com.application.api.rest.entities.Fabricante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Long> {


}

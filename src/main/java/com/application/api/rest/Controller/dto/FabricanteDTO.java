package com.application.api.rest.Controller.dto;

import com.application.api.rest.entities.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FabricanteDTO {


    private Long id;
    private String nombre;
    private List<Producto> listaProductos = new ArrayList<>();
}

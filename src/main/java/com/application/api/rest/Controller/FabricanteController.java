package com.application.api.rest.Controller;

import com.application.api.rest.Controller.dto.FabricanteDTO;
import com.application.api.rest.entities.Fabricante;
import com.application.api.rest.service.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fabricante")
public class FabricanteController {

    @Autowired
    private IFabricanteService fabricanteService;


    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
     Optional<Fabricante> optionalFabricante = fabricanteService.findById(id);

     if (optionalFabricante.isPresent()){
        Fabricante fabricante = optionalFabricante.get();

         FabricanteDTO fabricanteDTO = FabricanteDTO.builder()
                 .id(fabricante.getId())
                 .nombre(fabricante.getNombre())
                 .listaProductos(fabricante.getListaProductos())
                 .build();

         return  ResponseEntity.ok(fabricanteDTO);
     }
        return  ResponseEntity.notFound().build();
    }

    @GetMapping("/encuentratodos")
    public ResponseEntity<?> findAll(){

        List<FabricanteDTO> listaFabricantes = fabricanteService.findAll()
                .stream()
                .map(fabricante -> FabricanteDTO.builder()
                        .id(fabricante.getId())
                        .nombre(fabricante.getNombre())
                        .listaProductos(fabricante.getListaProductos())
                        .build())
                .toList();

        return ResponseEntity.ok(listaFabricantes);

    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody FabricanteDTO fabricanteDTO) throws URISyntaxException {

        if(fabricanteDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

    fabricanteService.save(Fabricante.builder()
            .nombre(fabricanteDTO.getNombre())
            .build());
    return ResponseEntity.created(new URI("/api/fabricante/guardar")).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> udate(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO){

        Optional<Fabricante> optionalFabricante = fabricanteService.findById(id);

        if (optionalFabricante.isPresent()) {
            Fabricante fabricante = optionalFabricante.get();
            fabricante.setNombre(fabricanteDTO.getNombre());
            fabricanteService.save(fabricante);

            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null) {
            fabricanteService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}

package com.application.api.rest.Controller;

import com.application.api.rest.Controller.dto.ProductoDTO;
import com.application.api.rest.entities.Producto;
import com.application.api.rest.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoCotroller {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Producto> optionalProducto = productoService.findById(id);

        if(optionalProducto.isPresent()){
            Producto producto = optionalProducto.get();
            ProductoDTO productoDTO = ProductoDTO.builder()
                    .id(producto.getId())
                    .nombre(producto.getNombre())
                    .precio(producto.getPrecio())
                    .fabricante(producto.getFabricante())
                    .build();
            return ResponseEntity.ok(productoDTO);
        }
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/encontrartodos")
    public ResponseEntity<?> findAll(){
        List<ProductoDTO> listaProductos = productoService.findAll()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .id(producto.getId())
                        .nombre(producto.getNombre())
                        .precio(producto.getPrecio())
                        .fabricante(producto.getFabricante())
                        .build())
                .toList();
        return ResponseEntity.ok(listaProductos);
    }
    @PostMapping("/guardar")
    public ResponseEntity save(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {

        if(productoDTO.getNombre().isBlank() || productoDTO.getPrecio() == null || productoDTO.getFabricante() == null){
            return ResponseEntity.badRequest().build();
        }

        Producto producto = Producto.builder()
                .nombre(productoDTO.getNombre())
                .precio(productoDTO.getPrecio())
                .fabricante(productoDTO.getFabricante())
        .build();
        productoService.save(producto);

        return ResponseEntity.created(new URI("/api/producto/guardar")).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,  @RequestBody ProductoDTO productoDTO){
        Optional<Producto> optionalProducto = productoService.findById(id);

        if (optionalProducto.isPresent()){
            Producto producto = optionalProducto.get();
            producto.setNombre(productoDTO.getNombre());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setFabricante(productoDTO.getFabricante());

            productoService.save(producto);
            return ResponseEntity.ok("Registro actualizado");

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id != null){
            productoService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}


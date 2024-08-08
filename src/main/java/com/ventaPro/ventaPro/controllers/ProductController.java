package com.ventaPro.ventaPro.controllers;


import com.ventaPro.ventaPro.entities.Client;
import com.ventaPro.ventaPro.entities.Product;
import com.ventaPro.ventaPro.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ventaPro/products")
@Tag(name="Productos (Controlador)", description = "Crud de productos")

public class ProductController {
    @Autowired
    private ProductService productService;

    // crea producto
    @PostMapping
    @Operation(summary = "Crear producto")
    public ResponseEntity<Product> createProduct(@RequestBody Product data){
        try{
            Product products = productService.createProduct(data);
            return new ResponseEntity<>(products, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }



    // devuelve lista productos
    @GetMapping
    @Operation(summary = "Lista de productos")
    public ResponseEntity<List<Product>> productsList(){
        try{
            List<Product> products = productService.productsList();
            return ResponseEntity.ok(products);

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // devuelve producto por id
    @GetMapping("/{id}")
    @Operation(summary = "Buscar producto por id")
    public Optional<Product> getById(@PathVariable ("id") Long id){
        try{
            return productService.findById(id);
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("Error al cargar producto");
        }
    }
    // elimina producto por id
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto por id")
    public void deleteById (@PathVariable ("id")Long id){
        try{
            productService.deleteById(id);
            System.out.println("producto eliminado");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    //modifica producto por id
    @PutMapping("/{id}")
    @Operation(summary = "Modificar producto por id")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProductOptional = productService.findById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Actualiza los datos del prodcuto
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setTitle(updatedProduct.getTitle());
            existingProduct.setStock(updatedProduct.getStock());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setBrand(updatedProduct.getBrand());

            // Guarda el producto actualizado
            Product savedProduct = productService.createProduct(existingProduct);

            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

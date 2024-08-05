package com.ventaPro.ventaPro.controllers;


import com.ventaPro.ventaPro.entities.Client;
import com.ventaPro.ventaPro.entities.Product;
import com.ventaPro.ventaPro.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ventaPro/products")

public class ProductController {
    @Autowired
    private ProductService productService;

    // crea cliente o modifica sabiendo el id
    @PostMapping
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
    public void deleteById (@PathVariable ("id")Long id){
        try{
            productService.deleteById(id);
            System.out.println("producto eliminado");
        }catch (Exception e){
            System.out.println(e);
        }

    }

}

package com.ventaPro.ventaPro.services;

import com.ventaPro.ventaPro.entities.Client;
import com.ventaPro.ventaPro.entities.Product;
import com.ventaPro.ventaPro.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // crear un producto nuevo o modifica sabiendo el id
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    // devolver lista de todos los productos
    public List<Product> productsList(){
        return productRepository.findAll();
    }

    // devolver producto por id
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    // filtra productos por marca
    public List<Product> findByBrand(String brand){
        return productRepository.findByBrand(brand);
    }

    // filtra productos por categoria
    public List<Product> findByCategory(String category){
        return productRepository.findByCategory(category);
    }

    // elimina producto por id
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }


}

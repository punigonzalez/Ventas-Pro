package com.ventaPro.ventaPro.repositories;

import com.ventaPro.ventaPro.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}

package com.ventaPro.ventaPro.repositories;

import com.ventaPro.ventaPro.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByClientIdAndDelivered(Long clientId,Boolean delivered);
}

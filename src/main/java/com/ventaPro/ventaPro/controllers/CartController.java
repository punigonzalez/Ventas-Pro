package com.ventaPro.ventaPro.controllers;
import com.ventaPro.ventaPro.entities.Cart;
import com.ventaPro.ventaPro.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("ventaPro/carts")
@Tag(name="Carritos (Controlador)", description = "Crud de carritos")

public class CartController {
   @Autowired private CartService cartService;



   @PostMapping("/{clid}/{prodid}/{amount}")
   @Operation(summary = "Crear carrito",description = "Genera un carrito al pasar como parametro el id del cliente, el id del producto y la cantidad del producto que desea llevar")
    public ResponseEntity<Cart> addToCart(@PathVariable Long clid, @PathVariable Long prodid,@PathVariable Integer amount){
      try{
           Cart cart = cartService.addToCart(clid,prodid,amount);
           return ResponseEntity.status(HttpStatus.CREATED).body(cart);
      }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{cartId}")
    @Operation(summary = "Eliminar carrito")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long cartId){
        try{
            cartService.deleteProductById(cartId);
            return ResponseEntity.noContent().build();

        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception e ){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }










}

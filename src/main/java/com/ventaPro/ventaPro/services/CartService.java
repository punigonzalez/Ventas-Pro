package com.ventaPro.ventaPro.services;

import com.ventaPro.ventaPro.entities.Cart;
import com.ventaPro.ventaPro.entities.Client;
import com.ventaPro.ventaPro.entities.Product;
import com.ventaPro.ventaPro.repositories.CartRepository;
import com.ventaPro.ventaPro.repositories.ClientRepository;
import com.ventaPro.ventaPro.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired private CartRepository cartRepository;
    @Autowired private ClientRepository clientRepository;
    @Autowired private ProductRepository productRepository;




    // agrega cliente, producto y cantidad al carrito
    public Cart addToCart(Long clientId, Long productId,int amount){
        Optional<Client> client = clientRepository.findById(clientId);
        Optional<Product> product = productRepository.findById(productId);
        if(client.isPresent() & product.isPresent()){
            Cart cart = new Cart();
            cart.setClient(client.get());
            cart.setProducts((List<Product>) product.get());
            cart.setPrice(product.get().getPrice());
            cart.setAmount(amount);
            cart.setDelivered(false);
            return cartRepository.save(cart);
        }else{
            throw new RuntimeException("Cliente o producto no encontrado");
        }

    }

    //borrar un producto del carrito por id
    public Cart deleteProductById(Long id) {
        Optional<Cart> cart= cartRepository.findById(id);
        if (cart.isPresent()){
            cartRepository.deleteById(id);
            return cart.get();
        }else{
            throw new RuntimeException("Carrito no encontrado");
        }
    }


    //leer los productos del carrito con delivered en false
    public List<Cart> findByClientIdAndDelivered(Long clientId){
        List<Cart> carts = cartRepository.findByClientIdAndDelivered(clientId,false);
        if(carts.isEmpty()){
            throw new RuntimeException("Carritos no encontrados");
        }else{
            return carts;
        }
    }

}

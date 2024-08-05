package com.ventaPro.ventaPro.controllers;
import com.ventaPro.ventaPro.entities.Client;
import com.ventaPro.ventaPro.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("ventaPro/clients")

public class ClientController {

    @Autowired private ClientService clientService;


    // crea cliente o modifica sabiendo el id
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client data){
        try{
            Client client = clientService.createClient(data);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }



    // devuelve lista clientes
   @GetMapping
    public ResponseEntity<List<Client>> clientList(){
        try{
            List<Client> clients = clientService.clientList();
            return ResponseEntity.ok(clients);

        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // devuelve cliente por id
    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable ("id") Long id){
        try{
            return clientService.findById(id);
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("Error al cargar usuario");
        }
    }
    // elimina cliente por id
    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable ("id")Long id){
        try{
            clientService.deleteById(id);
            System.out.println("usuario eliminado");
        }catch (Exception e){
            System.out.println(e);
        }

    }




}

package com.ventaPro.ventaPro.controllers;
import com.ventaPro.ventaPro.entities.Client;
import com.ventaPro.ventaPro.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("ventaPro/clients")
@Tag(name="Clientes (Controlador)", description = "Crud de clientes")

public class ClientController {

    @Autowired private ClientService clientService;





    // crea cliente
    @PostMapping
    @Operation(summary = "Crear usuario")
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
   @Operation(summary = "Lista de usuarios")
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
    @Operation(summary = "Buscar cliente por id")
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
    @Operation(summary = "Eliminar cliente por id")
    public void deleteById (@PathVariable ("id")Long id){
        try{
            clientService.deleteById(id);
            System.out.println("usuario eliminado");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    //modifica cliente por id
    @PutMapping("/{id}")
    @Operation(summary = "Modificar cliente por id")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        Optional<Client> existingClientOptional = clientService.findById(id);

        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();

            // Actualiza los datos del cliente
            existingClient.setName(updatedClient.getName());
            existingClient.setLastName(updatedClient.getLastName());
            existingClient.setDocNumber(updatedClient.getDocNumber());

            // Guarda el cliente actualizado
            Client savedClient = clientService.createClient(existingClient);

            return ResponseEntity.ok(savedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }









}

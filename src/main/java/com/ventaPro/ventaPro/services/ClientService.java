package com.ventaPro.ventaPro.services;


import com.ventaPro.ventaPro.entities.Client;
import com.ventaPro.ventaPro.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // crear un cliente nuevo o modifica sabiendo el id
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    // devolver lista de todos los clientes
    public List<Client> clientList(){
        return clientRepository.findAll();
    }

    // devolver cliente por id
    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }
    // elimina cliente por id
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }



}

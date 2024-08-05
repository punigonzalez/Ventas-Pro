package com.ventaPro.ventaPro.repositories;

import com.ventaPro.ventaPro.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}

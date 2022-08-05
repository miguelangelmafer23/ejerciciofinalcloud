package com.bosonit.BackWeb.Client.infraestructure.repository;

import com.bosonit.BackWeb.Client.domain.Client;
import com.bosonit.BackWeb.Client.infraestructure.DTOs.OutputClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByName(String name);
}

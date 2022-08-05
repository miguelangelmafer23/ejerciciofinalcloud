package com.bosonit.BackEmpresa.Client.infraestructure.repository;

import com.bosonit.BackEmpresa.Client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByName(String name);
}

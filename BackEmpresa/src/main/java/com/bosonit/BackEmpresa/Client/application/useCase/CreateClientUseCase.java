package com.bosonit.BackEmpresa.Client.application.useCase;


import com.bosonit.BackEmpresa.Client.application.port.CreateClientPort;
import com.bosonit.BackEmpresa.Client.domain.Client;
import com.bosonit.BackEmpresa.Client.infraestructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase implements CreateClientPort {

    @Autowired
    ClientRepository clientRepository;


    //Función para crear un cliente

    public String createClient(Client client) {
        clientRepository.save(client);
        return "Cliente creado correctamente";
    }
}
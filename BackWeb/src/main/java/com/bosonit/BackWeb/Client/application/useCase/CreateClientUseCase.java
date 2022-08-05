package com.bosonit.BackWeb.Client.application.useCase;

import com.bosonit.BackWeb.Client.application.port.CreateClientPort;
import com.bosonit.BackWeb.Client.domain.Client;
import com.bosonit.BackWeb.Client.infraestructure.repository.ClientRepository;
import com.bosonit.BackWeb.Config.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase implements CreateClientPort {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private EmailSenderService senderService;

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;
    //Función para crear un cliente

    public String createClient(Client client) {
        clientRepository.save(client);
        kafkaTemplate.send("TestTopic",client);
        return "Cliente creado correctamente";
    }
}
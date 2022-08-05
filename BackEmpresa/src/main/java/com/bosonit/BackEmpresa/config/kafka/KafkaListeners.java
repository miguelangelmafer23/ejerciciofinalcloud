package com.bosonit.BackEmpresa.config.kafka;

import com.bosonit.BackEmpresa.Client.domain.Client;
import com.bosonit.BackEmpresa.Client.infraestructure.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.kafka.common.protocol.types.Field;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClientRepository clientRepository;

    @KafkaListener(topics = "TestTopic", groupId = "group1")
    void listener(String data) {

        //Del String resultante quitamos la comillas dobles
        data=data.replace("\"","");

        //Separamos el String anterior para obtener los datos
        String[] datos = data.split("[,: }]");

        for (int i = 1; i < datos.length; i += 2) {
            System.out.println("Listener received: " + datos[i]);

        }
        Client client =new Client();
        client.setId_client(Integer.parseInt(datos[1]));
        client.setName(datos[3]);
        client.setSurname(datos[5]);
        client.setEmail(datos[7]);
        client.setPassword(datos[9]);
        client.setAdmin(Boolean.parseBoolean(datos[11]));

        clientRepository.save(client);
    }
}

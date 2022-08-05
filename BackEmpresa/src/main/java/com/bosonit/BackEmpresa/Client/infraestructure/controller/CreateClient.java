package com.bosonit.BackEmpresa.Client.infraestructure.controller;


import com.bosonit.BackEmpresa.Client.application.port.CreateClientPort;
import com.bosonit.BackEmpresa.Client.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v0/client")
public class CreateClient {

    @Autowired
    CreateClientPort createClientPort;

    @PostMapping()
    public String createClient(@RequestBody Client client){
        return createClientPort.createClient(client);
    }
}

package com.bosonit.BackWeb.Client.infraestructure.controller;

import com.bosonit.BackWeb.Client.application.port.DeleteClientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v0/client")
public class DeleteClient {

    @Autowired
    DeleteClientPort deleteClientPort;

    @DeleteMapping("/{id}")
    public String deleteClientById(@PathVariable Integer id){
        return deleteClientPort.deletePersonById(id);
    }
}

package com.bosonit.BackEmpresa.Client.infraestructure.controller;


import com.bosonit.BackEmpresa.Client.application.port.GetClientPort;
import com.bosonit.BackEmpresa.Client.infraestructure.DTOs.OutputClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v0/client")
public class GetClient {
    @Autowired
    GetClientPort getClientPort;

    @GetMapping("/{id}")
    public OutputClientDTO getClientById(@PathVariable Integer id) throws Exception{
        return getClientPort.getClientById(id);
    }

    @GetMapping("name/{name}")
    public List<OutputClientDTO> getClientsByName(@PathVariable String name){
        return getClientPort.getClientsByName(name);
    }

    @GetMapping("/all")
    public List<OutputClientDTO> getAllClients() {
        return getClientPort.getAllClients();
    }
}

package com.bosonit.BackWeb.Client.infraestructure.controller;

import com.bosonit.BackWeb.Client.application.port.UpdateClientPort;
import com.bosonit.BackWeb.Client.infraestructure.DTOs.InputClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/client")
public class UpdateClient {
    @Autowired
    UpdateClientPort updateClientPort;

    @PutMapping("/{id}")

    public String updateClientById(@PathVariable Integer id, @RequestBody InputClientDTO inputClientDTO){
        return  updateClientPort.updateClientById(id,inputClientDTO);
    }
}

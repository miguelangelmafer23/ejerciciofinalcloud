package com.bosonit.BackWeb.Client.infraestructure.controller;

import com.bosonit.BackWeb.Client.application.port.GetClientPort;
import com.bosonit.BackWeb.Client.infraestructure.DTOs.OutputClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String username, @RequestParam String password) {
        ResponseEntity<String> rs = new RestTemplate().getForEntity("http://localhost:8090/login?username="+ username +"&password=" + password,  String.class);
        return ResponseEntity.ok(rs.getBody());
    }
}

package com.bosonit.BackEmpresa.Trip.infraestructure.controller;


import com.bosonit.BackEmpresa.Trip.application.port.CreateTripPort;
import com.bosonit.BackEmpresa.Trip.infraestructure.DTOs.InputTripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v0/trip")
public class CreateTrip {

    @Autowired
    CreateTripPort createTripPort;

    @PostMapping
    public String createTrip(@RequestBody InputTripDTO inputTripDTO){
        return createTripPort.createTrip(inputTripDTO);
    }

}

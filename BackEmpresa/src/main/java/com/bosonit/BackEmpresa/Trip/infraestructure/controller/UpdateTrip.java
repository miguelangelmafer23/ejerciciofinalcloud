package com.bosonit.BackEmpresa.Trip.infraestructure.controller;


import com.bosonit.BackEmpresa.Trip.application.port.UpdateTripPort;
import com.bosonit.BackEmpresa.Trip.infraestructure.DTOs.InputTripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v0/trip")
public class UpdateTrip {

    @Autowired
    UpdateTripPort updateTripPort;

    @PutMapping("/{id}")
    public String updateTripById(@PathVariable Integer id, @RequestBody InputTripDTO inputTripDTO){
        return updateTripPort.updateTripById(id,inputTripDTO);
    }
}

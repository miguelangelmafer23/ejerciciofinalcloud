package com.bosonit.BackEmpresa.Trip.infraestructure.controller;

import com.bosonit.BackEmpresa.Trip.application.port.DeleteTripPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v0/trip")
public class DeleteTrip {

    @Autowired
    DeleteTripPort deleteTripPort;

    @DeleteMapping("/{id}")
    public String deleteTripById(@PathVariable Integer id){
        return deleteTripPort.deleteTripById(id);
    }

}

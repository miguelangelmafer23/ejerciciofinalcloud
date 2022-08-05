package com.bosonit.BackEmpresa.Trip.infraestructure.controller;



import com.bosonit.BackEmpresa.Trip.application.port.GetTripPort;
import com.bosonit.BackEmpresa.Trip.domain.Trip;
import com.bosonit.BackEmpresa.Trip.infraestructure.DTOs.OutputTripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v0/trip")
public class GetTrip {
    @Autowired
    GetTripPort getTripPort;

    @GetMapping("/{id}")
    public OutputTripDTO getTripById(@PathVariable Integer id) throws Exception{
        return getTripPort.getTripById(id);
    }
    @GetMapping("/all")
    public List<OutputTripDTO> getAllTrips() {
        return getTripPort.getAllTrips();
    }


    @GetMapping("/details")
    public List<Trip> getTripDetails(@RequestParam HashMap<String, String> conditions) {
        return getTripPort.getData(conditions);
    }
}

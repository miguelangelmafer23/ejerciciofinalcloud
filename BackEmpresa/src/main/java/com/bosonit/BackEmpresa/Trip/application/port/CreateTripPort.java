package com.bosonit.BackEmpresa.Trip.application.port;


import com.bosonit.BackEmpresa.Trip.infraestructure.DTOs.InputTripDTO;

public interface CreateTripPort {
    public String createTrip(InputTripDTO inputTripDTO);
}

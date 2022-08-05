package com.bosonit.BackEmpresa.Trip.application.port;


import com.bosonit.BackEmpresa.Trip.infraestructure.DTOs.InputTripDTO;

public interface UpdateTripPort {
    public String updateTripById(Integer id, InputTripDTO updatedTrip);
}

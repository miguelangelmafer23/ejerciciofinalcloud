package com.bosonit.BackWeb.Trip.application.port;

import com.bosonit.BackWeb.Trip.infraestructure.DTOs.InputTripDTO;


public interface UpdateTripPort {
    public String updateTripById(Integer id, InputTripDTO updatedTrip);
}

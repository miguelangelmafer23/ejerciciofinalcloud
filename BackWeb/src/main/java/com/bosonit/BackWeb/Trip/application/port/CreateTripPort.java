package com.bosonit.BackWeb.Trip.application.port;

import com.bosonit.BackWeb.Trip.infraestructure.DTOs.InputTripDTO;

public interface CreateTripPort {
    public String createTrip(InputTripDTO inputTripDTO);
}

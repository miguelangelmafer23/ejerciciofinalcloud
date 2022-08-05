package com.bosonit.BackWeb.Trip.application.port;

import com.bosonit.BackWeb.Trip.domain.Trip;
import com.bosonit.BackWeb.Trip.infraestructure.DTOs.OutputTripDTO;

import java.util.HashMap;
import java.util.List;


public interface GetTripPort {
    public OutputTripDTO getTripById(Integer id) throws Exception;
    public List<OutputTripDTO> getAllTrips();
    public List<Trip> getData(HashMap<String, String> conditions);
}

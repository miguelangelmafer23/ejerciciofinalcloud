package com.bosonit.BackWeb.Trip.application.useCase;

import com.bosonit.BackWeb.Trip.application.port.CreateTripPort;
import com.bosonit.BackWeb.Trip.domain.Trip;
import com.bosonit.BackWeb.Trip.infraestructure.DTOs.InputTripDTO;
import com.bosonit.BackWeb.Trip.infraestructure.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTripUseCase implements CreateTripPort {
    @Autowired
    TripRepository tripRepository;
    @Autowired
    ModelMapper modelMapper;

    public String createTrip(InputTripDTO inputTripDTO){
        Trip trip =modelMapper.map(inputTripDTO,Trip.class);
        tripRepository.save(trip);
        return "Viaje creado correctamente";
    }

}

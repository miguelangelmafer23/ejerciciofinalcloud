package com.bosonit.BackEmpresa.Trip.application.useCase;


import com.bosonit.BackEmpresa.Trip.application.port.CreateTripPort;
import com.bosonit.BackEmpresa.Trip.domain.Trip;
import com.bosonit.BackEmpresa.Trip.infraestructure.DTOs.InputTripDTO;
import com.bosonit.BackEmpresa.Trip.infraestructure.repository.TripRepository;
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

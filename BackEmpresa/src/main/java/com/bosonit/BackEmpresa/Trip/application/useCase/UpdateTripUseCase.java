package com.bosonit.BackEmpresa.Trip.application.useCase;



import com.bosonit.BackEmpresa.Trip.application.port.UpdateTripPort;
import com.bosonit.BackEmpresa.Trip.domain.Trip;
import com.bosonit.BackEmpresa.Trip.infraestructure.DTOs.InputTripDTO;
import com.bosonit.BackEmpresa.Trip.infraestructure.repository.TripRepository;
import com.bosonit.BackEmpresa.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UpdateTripUseCase implements UpdateTripPort {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    ModelMapper modelMapper;

    public String updateTripById(Integer id, InputTripDTO updatedTrip) {
        if (tripRepository.findById(id).isEmpty()) {
            throw new NotFoundException("El viaje con el id " + id + " no existe");
        } else {
            Trip trip = modelMapper.map(updatedTrip, Trip.class);
            trip.setId_trip(id);
            tripRepository.save(trip);
        }
        return "Viaje actualizado";
    }
}

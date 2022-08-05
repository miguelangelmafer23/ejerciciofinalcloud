package com.bosonit.BackEmpresa.Trip.application.useCase;

import com.bosonit.BackEmpresa.Trip.application.port.DeleteTripPort;
import com.bosonit.BackEmpresa.Trip.infraestructure.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeleteTripUseCase implements DeleteTripPort {

    @Autowired
    TripRepository tripRepository;

    public String deleteTripById(Integer id){
        tripRepository.deleteById(id);
        return "Ruta de viaje eliminada";
    }
}

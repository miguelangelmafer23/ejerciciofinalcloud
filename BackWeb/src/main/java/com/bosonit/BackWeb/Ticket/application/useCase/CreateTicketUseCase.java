package com.bosonit.BackWeb.Ticket.application.useCase;

import com.bosonit.BackWeb.Client.domain.Client;
import com.bosonit.BackWeb.Client.infraestructure.repository.ClientRepository;
import com.bosonit.BackWeb.Exceptions.NotFoundException;
import com.bosonit.BackWeb.Ticket.application.port.CreateTicketPort;
import com.bosonit.BackWeb.Ticket.domain.Ticket;
import com.bosonit.BackWeb.Ticket.infraestructure.DTOs.InputTicketDTO;
import com.bosonit.BackWeb.Ticket.infraestructure.repository.TicketRepository;
import com.bosonit.BackWeb.Trip.domain.Trip;
import com.bosonit.BackWeb.Trip.infraestructure.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateTicketUseCase implements CreateTicketPort {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    ModelMapper modelMapper;

    public String createTicket(InputTicketDTO inputTicketDTO){
        Optional<Client> client = clientRepository.findById(inputTicketDTO.getId_client());
        if(client.isEmpty()){
            throw new NotFoundException("El ID de cliente indicado no existe");
        }
        Optional<Trip> trip = tripRepository.findById(inputTicketDTO.getId_trip());
        if(trip.isEmpty()){
            throw new NotFoundException("El ID de viaje indicado no existe");
        }
        Ticket ticket = modelMapper.map(inputTicketDTO,Ticket.class);
        ticket.setClient(client.get());
        ticket.setTrip(trip.get());
        ticketRepository.save(ticket);
        return "Ticket adquirido correctamente";
    }

}

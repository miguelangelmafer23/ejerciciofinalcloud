package com.bosonit.BackWeb.Ticket.infraestructure.controller;

import com.bosonit.BackWeb.Ticket.application.port.CreateTicketPort;
import com.bosonit.BackWeb.Ticket.infraestructure.DTOs.InputTicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/ticket")
public class CreateTicket {

    @Autowired
    CreateTicketPort createTicketPort;

    @PostMapping
    public String createTicket(@RequestBody InputTicketDTO inputTicketDTO){
        return createTicketPort.createTicket(inputTicketDTO);
    }
}

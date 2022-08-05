package com.bosonit.BackEmpresa.Ticket.application.port;


import com.bosonit.BackEmpresa.Ticket.infraestructure.DTOs.InputTicketDTO;

public interface CreateTicketPort {
    public String createTicket(InputTicketDTO inputTicketDTO);
}

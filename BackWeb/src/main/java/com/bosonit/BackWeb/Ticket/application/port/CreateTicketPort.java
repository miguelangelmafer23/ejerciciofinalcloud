package com.bosonit.BackWeb.Ticket.application.port;

import com.bosonit.BackWeb.Ticket.infraestructure.DTOs.InputTicketDTO;

public interface CreateTicketPort {
    public String createTicket(InputTicketDTO inputTicketDTO);
}

package com.bosonit.BackEmpresa.Ticket.infraestructure.DTOs;

import lombok.Data;


@Data
public class InputTicketDTO {
    private Integer id_client;
    private Integer id_trip;
    private String status;
}

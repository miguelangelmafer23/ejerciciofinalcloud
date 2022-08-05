package com.bosonit.BackWeb.Ticket.infraestructure.repository;

import com.bosonit.BackWeb.Ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}

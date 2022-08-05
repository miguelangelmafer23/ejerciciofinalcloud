package com.bosonit.BackEmpresa.Ticket.domain;

import com.bosonit.BackEmpresa.Client.domain.Client;
import com.bosonit.BackEmpresa.Trip.domain.Trip;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_client")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_trip")
    private Trip trip;
}


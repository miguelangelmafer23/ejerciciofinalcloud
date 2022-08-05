package com.bosonit.BackEmpresa.Client.domain;


import com.bosonit.BackEmpresa.Ticket.domain.Ticket;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue
    private Integer id_client;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Boolean admin;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}

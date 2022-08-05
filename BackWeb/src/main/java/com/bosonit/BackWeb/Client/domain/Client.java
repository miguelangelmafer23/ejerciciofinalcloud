package com.bosonit.BackWeb.Client.domain;

import com.bosonit.BackWeb.Ticket.domain.Ticket;
import lombok.Data;
import org.hibernate.annotations.Type;

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
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}

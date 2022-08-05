package com.bosonit.BackWeb.Trip.domain;

import com.bosonit.BackWeb.Ticket.domain.Ticket;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;



@Entity
@Data
public class Trip {
    @Id
    @GeneratedValue
    private Integer id_trip;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer asientos;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public void restaAsiento(){
    }
}





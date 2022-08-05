package com.bosonit.BackEmpresa.Trip.infraestructure.DTOs;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Data
public class InputTripDTO {
    private Integer id_trip;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer asientos;
}

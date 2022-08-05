package com.bosonit.BackWeb.Client.infraestructure.DTOs;

import lombok.Data;
@Data
public class OutputClientDTO {
    private Integer id_client;
    private String name;
    private String surname;
    private String email;
}

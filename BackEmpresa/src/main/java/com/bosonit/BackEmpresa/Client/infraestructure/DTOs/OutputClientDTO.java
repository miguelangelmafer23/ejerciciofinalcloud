package com.bosonit.BackEmpresa.Client.infraestructure.DTOs;

import lombok.Data;
@Data
public class OutputClientDTO {
    private Integer id_client;
    private String name;
    private String password;
    private String surname;
    private String email;
    private Boolean admin;
}

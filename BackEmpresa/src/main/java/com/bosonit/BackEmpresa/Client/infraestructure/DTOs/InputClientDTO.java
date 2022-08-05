package com.bosonit.BackEmpresa.Client.infraestructure.DTOs;

import lombok.Data;

import java.util.UUID;

public class InputClientDTO {
    @Data
    public class OutputClientDTO {
        private Integer id_client;
        private String name;
        private String surname;
        private String email;
        private String password;
        private Boolean admin;
    }
}

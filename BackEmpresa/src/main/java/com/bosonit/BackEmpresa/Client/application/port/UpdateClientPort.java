package com.bosonit.BackEmpresa.Client.application.port;


import com.bosonit.BackEmpresa.Client.infraestructure.DTOs.InputClientDTO;

public interface UpdateClientPort {
    public String updateClientById(Integer id, InputClientDTO updatedClient);
}

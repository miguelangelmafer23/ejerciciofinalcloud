package com.bosonit.BackWeb.Client.application.port;

import com.bosonit.BackWeb.Client.infraestructure.DTOs.InputClientDTO;


public interface UpdateClientPort {
    public String updateClientById(Integer id, InputClientDTO updatedClient);
}

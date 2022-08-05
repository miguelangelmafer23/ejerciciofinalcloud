package com.bosonit.BackEmpresa.Client.application.port;

import com.bosonit.BackEmpresa.Client.infraestructure.DTOs.OutputClientDTO;


import java.util.List;

public interface GetClientPort {
    public OutputClientDTO getClientById(Integer id) throws Exception;
    public List<OutputClientDTO> getAllClients();
    public List<OutputClientDTO> getClientsByName(String name);
}

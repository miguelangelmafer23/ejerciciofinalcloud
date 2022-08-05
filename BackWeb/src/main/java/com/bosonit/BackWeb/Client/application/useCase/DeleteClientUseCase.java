package com.bosonit.BackWeb.Client.application.useCase;

import com.bosonit.BackWeb.Client.application.port.DeleteClientPort;
import com.bosonit.BackWeb.Client.infraestructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteClientUseCase implements DeleteClientPort {
    @Autowired
    ClientRepository clientRepository;

    public String deletePersonById(Integer id){
        clientRepository.deleteById(id);
        return "Cliente eliminado";
    }
}

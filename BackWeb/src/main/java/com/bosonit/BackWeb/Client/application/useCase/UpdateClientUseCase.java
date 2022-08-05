package com.bosonit.BackWeb.Client.application.useCase;

import com.bosonit.BackWeb.Client.application.port.UpdateClientPort;
import com.bosonit.BackWeb.Client.domain.Client;
import com.bosonit.BackWeb.Client.infraestructure.DTOs.InputClientDTO;
import com.bosonit.BackWeb.Client.infraestructure.repository.ClientRepository;
import com.bosonit.BackWeb.Exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UpdateClientUseCase implements UpdateClientPort {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;

    public String updateClientById(Integer id, InputClientDTO updatedClient){
        if(clientRepository.findById(id).isEmpty()){
            throw new NotFoundException("El cliente con el id " + id + " no existe");
        }else{
            Client client = modelMapper.map(updatedClient,Client.class);
            client.setId_client(id);
            clientRepository.save(client);
        }
        return "Cliente actualizado";
    }
}

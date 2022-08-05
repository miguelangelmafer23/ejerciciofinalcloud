package com.bosonit.BackEmpresa.Client.application.useCase;


import com.bosonit.BackEmpresa.Client.application.port.GetClientPort;
import com.bosonit.BackEmpresa.Client.domain.Client;
import com.bosonit.BackEmpresa.Client.infraestructure.DTOs.OutputClientDTO;
import com.bosonit.BackEmpresa.Client.infraestructure.repository.ClientRepository;
import com.bosonit.BackEmpresa.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetClientUseCase implements GetClientPort {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ModelMapper modelMapper;

    public OutputClientDTO getClientById(Integer id) throws Exception{
        Client client = clientRepository.findById(id).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        OutputClientDTO outPutClientDTO = modelMapper.map(client, OutputClientDTO.class);
        return outPutClientDTO;
    }

    public List<OutputClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        TypeToken<List<OutputClientDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputClientDTO> outPutClientDTO = modelMapper.map(clients , typeToken.getType());
        return outPutClientDTO;
    }

    public List<OutputClientDTO> getClientsByName(String name) {
        List<Client> clients = clientRepository.findByName(name);
        TypeToken<List<OutputClientDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputClientDTO> outPutClientDTO = modelMapper.map(clients , typeToken.getType());
        return outPutClientDTO;
    }

}

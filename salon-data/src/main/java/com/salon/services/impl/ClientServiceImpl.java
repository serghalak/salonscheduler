package com.salon.services.impl;

import com.salon.dto.ClientDto;
import com.salon.model.Client;
import com.salon.repository.ClientRepo;
import com.salon.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {


    private ClientRepo clientRepo;
    private ModelMapper modelMapper;


    public ClientServiceImpl(ClientRepo clientRepo
        ,ModelMapper modelMapper) {
        this.clientRepo=clientRepo;
        this.modelMapper=modelMapper;
    }


    @Override
    public Set<ClientDto> findAll() {
        return null;
    }

    @Override
    public ClientDto findById(Long aLong) {
        return null;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {

        Client client = convertToClient(clientDto);
        Client saveClient = clientRepo.save(client);
        ClientDto saveClientDto = convertToClientDto(saveClient);
        return saveClientDto;

    }

    @Override
    public void delete(ClientDto object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    private Client convertToClient(ClientDto clientDto){
        return modelMapper.map(clientDto,Client.class);
    }

    private ClientDto convertToClientDto(Client client)   {
        return modelMapper.map(client,ClientDto.class);
    }
}
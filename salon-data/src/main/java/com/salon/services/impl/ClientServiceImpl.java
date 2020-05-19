package com.salon.services.impl;

import com.salon.dto.ClientDto;
import com.salon.dto.MasterDto;
import com.salon.model.Client;
import com.salon.model.Master;
import com.salon.repository.ClientRepo;
import com.salon.services.ClientService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Optional;
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
            return convertToSetClientDto(clientRepo.findByIsActiveTrue());
    }

    @Override
    public ClientDto findById(Long id) {
        Optional<Client> client =clientRepo.findByIdAndIsActiveTrue(id);
        if(!client.isPresent()){
            throw new RuntimeException("Client not found");
        }
        return convertToClientDto(client.get());

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
//-----------------------------------------------------------------------------------
    private Client convertToClient(ClientDto clientDto){
        return modelMapper.map(clientDto,Client.class);
    }

    private ClientDto convertToClientDto(Client client)   {
        return modelMapper.map(client,ClientDto.class);
    }

    private Set<ClientDto>convertToSetClientDto(Iterable<Client>clients){
        Type listType=new TypeToken<Set<ClientDto>>() {}.getType();
        return modelMapper.map(clients,listType);
    }
}

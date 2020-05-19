package com.salon.controller;



import com.salon.datasourcebeans.MySqlDataSource;
import com.salon.dto.ClientDto;
import com.salon.dto.MasterDto;
import com.salon.services.ClientService;
import com.salon.ui.model.request.ClientRequest;
import com.salon.ui.model.request.MasterRequest;
import com.salon.ui.model.response.ClientResponse;
import com.salon.ui.model.response.MasterResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    private ClientService clientService;
    private ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

//    @GetMapping
//    public void getAllClientAppointments(){
//        System.out.println("api/clients get method ...." );
//
//    }

    @GetMapping
    public Set<ClientResponse> getAllClients(){
         return convertToSetClientResponse(clientService.findAll());
    }


    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest){
        return createAndUpdateClient(clientRequest);
    }

    @GetMapping(path = "/{id}")
    public ClientResponse getClientById(@PathVariable("id")Long id){
        return convertToClientResponse(clientService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteClientById(@PathVariable("id")Long id){
        clientService.deleteById(id);
    }

    @PutMapping
    ClientResponse updateClient(@RequestBody ClientRequest clientRequest){
        return createAndUpdateClient(clientRequest);
    }


//--------------------------------------------------------------------------

    private ClientResponse createAndUpdateClient(ClientRequest clientRequest){
        ClientDto clientDto = convertToClientDto(clientRequest);
        ClientDto saveClientDto = clientService.save(clientDto);
        ClientResponse saveClientResponse =convertToClientResponse(saveClientDto);
        return saveClientResponse;
    }


    private ClientDto convertToClientDto(ClientRequest clientRequest){
        return modelMapper.map(clientRequest,ClientDto.class);
    }

    private ClientResponse convertToClientResponse(ClientDto clientDto){
        return modelMapper.map(clientDto,ClientResponse.class);
    }

    private Set<ClientResponse>convertToSetClientResponse(Set<ClientDto> clients){
        Set<ClientResponse>clientResponses=new HashSet<>();
        for(ClientDto clientDto : clients){
            clientResponses.add(convertToClientResponse(clientDto));
        }
        return clientResponses;
    }

}

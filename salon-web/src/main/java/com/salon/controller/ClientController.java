package com.salon.controller;



import com.salon.datasourcebeans.MySqlDataSource;
import com.salon.dto.ClientDto;
import com.salon.services.ClientService;
import com.salon.ui.model.request.ClientRequest;
import com.salon.ui.model.response.ClientResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    private ClientService clientService;
    private ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public void getAllClientAppointments(){
        System.out.println("api/clients get method ...." );

    }

    @PostMapping
    public ClientResponse createUser(@RequestBody ClientRequest clientRequest){

        ClientDto clientDto = convertToClientDto(clientRequest);
        ClientDto saveClientDto = clientService.save(clientDto);
        ClientResponse saveClientResponse = convertToClientResponse(saveClientDto);
        //System.out.println(clientRequest);
        return saveClientResponse;
    }

    private ClientDto convertToClientDto(ClientRequest clientRequest){
        return modelMapper.map(clientRequest,ClientDto.class);
    }

    private ClientResponse convertToClientResponse(ClientDto clientDto){
        return modelMapper.map(clientDto,ClientResponse.class);
    }

}

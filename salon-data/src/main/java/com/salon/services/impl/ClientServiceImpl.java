package com.salon.services.impl;

import com.salon.model.Client;
import com.salon.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientService clientService;

    public ClientServiceImpl(ClientService clientService) {
        this.clientService = clientService;
    }


    @Override
    public Set<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(Long aLong) {
        return null;
    }

    @Override
    public Client save(Client object) {
        return null;
    }

    @Override
    public void delete(Client object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}

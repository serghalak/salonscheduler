package com.salon.services;


import com.salon.model.Client;

import java.util.Set;

public interface ClientService
        extends CrudService<Client,Long> {

    Set<Client> findByLastName(String lastName);

}

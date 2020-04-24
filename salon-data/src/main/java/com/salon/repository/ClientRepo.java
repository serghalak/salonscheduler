package com.salon.repository;


import com.salon.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends
        PagingAndSortingRepository<Client,Long> {

}

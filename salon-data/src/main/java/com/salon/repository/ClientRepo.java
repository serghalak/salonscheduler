package com.salon.repository;


import com.salon.model.Client;
import com.salon.model.Master;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ClientRepo extends
        PagingAndSortingRepository<Client,Long> {
    Set<Client> findByIsActiveTrue();

    Optional<Master> findByIdAndIsActiveTrue(Long id);
}

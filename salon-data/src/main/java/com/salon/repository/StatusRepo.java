package com.salon.repository;

import com.salon.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepo
        extends CrudRepository<Status,Long> {
}

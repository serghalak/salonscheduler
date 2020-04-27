package com.salon.repository;


import com.salon.model.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepo
        extends CrudRepository<Authority,Long> {
}

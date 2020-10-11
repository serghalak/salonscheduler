package com.salon.repository.security;


import com.salon.model.security.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepo
        extends CrudRepository<Authority,Long> {
}

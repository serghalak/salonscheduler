package com.salon.repository.security;

import com.salon.model.security.Authority;
import com.salon.model.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Long> {
}

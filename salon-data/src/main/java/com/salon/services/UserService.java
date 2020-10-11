package com.salon.services;

import com.salon.dto.security.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService
        extends CrudService<UserDto,Long> , UserDetailsService {
}

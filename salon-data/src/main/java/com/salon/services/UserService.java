package com.salon.services;

import com.salon.dto.UserDto;
import com.salon.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService
        extends CrudService<UserDto,Long> , UserDetailsService {
}

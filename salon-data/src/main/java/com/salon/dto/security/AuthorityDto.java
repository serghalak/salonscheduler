package com.salon.dto.security;

import com.salon.dto.security.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class AuthorityDto implements Serializable {

    private Long id;
    private String permission;
    private Set<RoleDto> roles;

}
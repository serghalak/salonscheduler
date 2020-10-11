package com.salon.dto.security;

import com.salon.model.security.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto implements Serializable {

    private Integer id;

    private String roleName;

    private Set<UserDto> users;

    private Set<AuthorityDto>authorities;
}

package com.salon.dto;

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
    private String roleName;
    private UserDto userDto;

}
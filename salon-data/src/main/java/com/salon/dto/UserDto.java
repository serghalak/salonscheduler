package com.salon.dto;

import com.salon.ui.model.request.AuthorityRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends PersonDto {

    private String activateCode;

    private boolean active=false;

    private String password;

    private String userId;

    private String userName;

    private Long personId;

    private Set<AuthorityRequest> authorities=new HashSet<>();
}

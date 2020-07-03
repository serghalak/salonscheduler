package com.salon.dto;

import com.salon.ui.model.request.AuthorityRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    private String activateCode;

    private boolean active=false;

    private String password;

    private String userId;

    private String userName;

    private Long personId;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    //private Set<AuthorityRequest> authorities=new HashSet<>();
    private AuthorityDto authority;
}

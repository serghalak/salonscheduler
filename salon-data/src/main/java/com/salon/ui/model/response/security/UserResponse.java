package com.salon.ui.model.response.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private String userId;
    private String username;
    private Boolean active;
    //private Boolean userIsClient=true;
    //private Set<AuthorityResponse> authorities=new HashSet<>();

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    private AuthorityResponse authority;
}

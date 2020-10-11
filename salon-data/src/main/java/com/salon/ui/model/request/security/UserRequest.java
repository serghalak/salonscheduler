package com.salon.ui.model.request.security;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    //private String userId;
    private String password;
    private String username;
    //private Set<AuthorityRequest> authorities=new HashSet<>();

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    //private AuthorityRequest authority;

}

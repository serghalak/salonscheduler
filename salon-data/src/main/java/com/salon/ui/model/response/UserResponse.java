package com.salon.ui.model.response;

import com.salon.model.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse extends PersonResponse{

    private String userId;
    private String userName;
    private Boolean active;
    //private Boolean userIsClient=true;
    private Set<AuthorityResponse> authorities=new HashSet<>();
}

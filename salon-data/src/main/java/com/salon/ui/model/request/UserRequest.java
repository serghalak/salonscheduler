package com.salon.ui.model.request;


import com.salon.model.Authority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest extends PersonRequest{

    private String userId;
    private String password;
    private String userName;
    private Set<AuthorityRequest> authorities=new HashSet<>();


}

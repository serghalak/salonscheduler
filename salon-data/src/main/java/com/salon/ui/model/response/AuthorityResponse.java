package com.salon.ui.model.response;


import com.salon.model.IdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorityResponse   {

    private Long id;
    private String roleName;
}

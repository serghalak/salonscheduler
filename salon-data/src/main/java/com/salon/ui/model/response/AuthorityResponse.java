package com.salon.ui.model.response;


import com.salon.model.IdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorityResponse  extends IdEntity {

    private String roleName;
}

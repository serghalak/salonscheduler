package com.salon.ui.model.request;


import com.salon.model.IdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorityRequest extends IdEntity {

    private String roleName;;
}

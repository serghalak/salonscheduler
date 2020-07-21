package com.salon.ui.model.request.security;


import com.salon.model.IdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorityRequest extends IdEntity {

    private String permission;

}

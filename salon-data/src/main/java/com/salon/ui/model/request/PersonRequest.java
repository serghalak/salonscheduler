package com.salon.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest implements Serializable {

    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;

}

package com.salon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto implements Serializable {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}

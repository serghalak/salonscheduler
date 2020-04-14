package com.salon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@Entity
public class Person extends IdEntity{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id",
            referencedColumnName = "id")
    private User user;

}

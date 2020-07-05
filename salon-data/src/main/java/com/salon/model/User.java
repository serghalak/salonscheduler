package com.salon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class User extends IdEntity {

    private String activateCode;

    private boolean active=false;

    private String password;

    private String userId;

    @Column(nullable = false,length = 50,unique = true)
    private String userName;

    private Long personId;


    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Column(nullable = false,unique = true)
    private String email;

    @ManyToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "authority_id",referencedColumnName = "id")
    private Authority authority;





}

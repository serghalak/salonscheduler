package com.salon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class User extends IdEntity {

    private String activateCode;

    private boolean active=false;

    private String password;

    private String userId;

    @Column(nullable = false,length = 50)
    private String userName;

    private Long personId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "authority_id",referencedColumnName = "id")
    private Authority authority;



}

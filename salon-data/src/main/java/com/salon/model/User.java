package com.salon.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User extends IdEntity {

    private String activateCode;

    private boolean active=false;

    private String password;

    @Column(nullable = false,length = 50)
    private String userName;

    private String userId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "authority_id",referencedColumnName = "id")
    private Authority authority;

}

package com.salon.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority extends IdEntity {

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "authority")
    private Set<User> users=new HashSet<>();



}

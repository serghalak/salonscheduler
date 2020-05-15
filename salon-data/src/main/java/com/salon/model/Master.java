package com.salon.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Master extends Person{

    @OneToMany(mappedBy = "master")
    private Set<Appointment> appointments=
            new HashSet<>();

    @ManyToMany//(fetch=Fetch.EAGER)
    @JoinTable(name = "master_specialization"
            ,joinColumns = @JoinColumn(name = "master_id",referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(name="specialization_id",referencedColumnName = "id"))
    private Set<Specialization> specializations=new HashSet<>();


}

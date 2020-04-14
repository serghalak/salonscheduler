package com.salon.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Master extends Person{

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id"
            ,referencedColumnName = "id")
    private Person person;

    @OneToMany(mappedBy = "master")
    private Set<Appointment> appointments=
            new HashSet<>();
}

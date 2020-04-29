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
}

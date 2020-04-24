package com.salon.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client extends Person  {



    @OneToMany(mappedBy = "client")
    private Set<Appointment> appointments=
            new HashSet<>();


}

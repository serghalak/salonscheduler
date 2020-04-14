package com.salon.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client extends Person  {

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id"
            ,referencedColumnName = "id")
    private Person person;

}

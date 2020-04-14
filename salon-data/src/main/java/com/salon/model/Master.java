package com.salon.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
}

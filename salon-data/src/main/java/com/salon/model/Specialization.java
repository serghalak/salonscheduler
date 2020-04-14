package com.salon.model;


//import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Specialization extends IdEntity  {


    //@Column
    private String specializationName;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="master_specialization"
            ,joinColumns = @JoinColumn(
                    name = "specialization_id"
                    ,referencedColumnName = "id")
            ,inverseJoinColumns = @JoinColumn(
                    name="master_id"
                    ,referencedColumnName = "id"))
    private Set<Master> masters=new HashSet<>();

}
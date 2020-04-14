package com.salon.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Status extends IdEntity{

    //@Column
    private String statusName;

    @OneToMany(mappedBy = "status")
    private List<Appointment> appointments=
            new ArrayList<>();

}

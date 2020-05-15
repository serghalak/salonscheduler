package com.salon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends IdEntity{

    //@Column
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    //@Column
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    //@Column
    private String room;
    //@Column
    private String description;



    @ManyToOne
    @JoinColumn(name="master_id"
            ,referencedColumnName = "id")
    private Master master;

    @ManyToOne
    @JoinColumn(name="client_id"
            ,referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="status_id"
            ,referencedColumnName = "id")
    private Status status;

}

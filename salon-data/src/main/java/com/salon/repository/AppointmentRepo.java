package com.salon.repository;

import com.salon.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepo
        extends CrudRepository<Appointment,Long> {
}

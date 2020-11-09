package com.learning.jpa.clinic_appointment_service.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.clinic_appointment_service.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

}

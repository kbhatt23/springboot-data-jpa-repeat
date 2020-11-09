package com.learning.jpa.clinic_appointment_service.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.clinic_appointment_service.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

	List<Patient> findAll();
}

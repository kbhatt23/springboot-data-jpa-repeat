package com.learning.jpa.clinic_appointment_service.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.clinic_appointment_service.entities.Doctor;
import com.learning.jpa.clinic_appointment_service.entities.Speciality;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

	List<Doctor> findAll();
	
	List<Doctor> findBySpeciality(Speciality speciality);
}

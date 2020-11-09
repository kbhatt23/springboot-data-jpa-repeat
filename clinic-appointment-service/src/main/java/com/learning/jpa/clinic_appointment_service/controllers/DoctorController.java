package com.learning.jpa.clinic_appointment_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.clinic_appointment_service.bean.AppointmentDTO;
import com.learning.jpa.clinic_appointment_service.bean.DoctorDTO;
import com.learning.jpa.clinic_appointment_service.bean.PatientVO;
import com.learning.jpa.clinic_appointment_service.entities.Speciality;
import com.learning.jpa.clinic_appointment_service.services.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	@Autowired
	private DoctorService service;

	@GetMapping
	public List<DoctorDTO> findAllDoctors(){
		return service.findAllDoctors();
	}
	
	@GetMapping("/{idStr}")
	public DoctorDTO findDoctorById(@PathVariable String idStr){
		return service.findDoctor(idStr);
	}
	
	@PostMapping
	public void createDoctor(@RequestBody DoctorDTO doctorDTO) {
		service.createDoctor(doctorDTO);
	}
	
	@GetMapping("/speciality/{specialityStr}")
	public List<DoctorDTO> findBySpeciality(@PathVariable String specialityStr){
		Speciality speciality = Speciality.valueOf(specialityStr);
		return service.findDoctorsBySpeciality(speciality);
	}
	
	@PutMapping
	public void updateDoctor(@RequestBody DoctorDTO doctorDTO) {
		service.updateDoctor(doctorDTO);
	}
	
	@GetMapping("/{idStr}/patients")
	public List<PatientVO> findAllPAtients(@PathVariable String idStr){
		return service.findAllPatientsOfDoctor(idStr);
	}
	
	@GetMapping("/{idStr}/appointments")
	public List<AppointmentDTO> findAllAppointments(@PathVariable String idStr){
		return service.findAllAppointments(idStr);
	}
}

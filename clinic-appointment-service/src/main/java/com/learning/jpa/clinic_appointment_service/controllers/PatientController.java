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
import com.learning.jpa.clinic_appointment_service.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {


	@Autowired
	private PatientService service;

	@GetMapping
	public List<PatientVO> findAllPatients(){
		return service.findAllPatients();
	}
	
	@GetMapping("/{idStr}")
	public PatientVO findPatientById(@PathVariable String idStr){
		return service.findPatient(idStr);
	}
	
	@PostMapping
	public void createPatient(@RequestBody PatientVO patientVO) {
		service.createPatient(patientVO);
	}
	@PutMapping
	public void updatePatient(@RequestBody PatientVO patientVO) {
		service.updatePatient(patientVO);
	}
	
	@GetMapping("/{idStr}/doctors")
	public List<DoctorDTO> findPatientsDoctorById(@PathVariable String idStr){
		return service.findAllDoctorsOfPatient(idStr);
	}
	
	@GetMapping("/{idStr}/appointments")
	public List<AppointmentDTO> findAllAppointments(@PathVariable String idStr){
		return service.findAllAppointments(idStr);
	}
	
	

}

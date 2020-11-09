package com.learning.jpa.clinic_appointment_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.learning.jpa.clinic_appointment_service.bean.AppointmentDTO;
import com.learning.jpa.clinic_appointment_service.bean.DoctorDTO;
import com.learning.jpa.clinic_appointment_service.bean.PatientVO;
import com.learning.jpa.clinic_appointment_service.entities.Appointment;
import com.learning.jpa.clinic_appointment_service.entities.Doctor;
import com.learning.jpa.clinic_appointment_service.entities.Patient;
import com.learning.jpa.clinic_appointment_service.repositories.PatientRepository;
@Service
public class PatientService {



	@Autowired
	private PatientRepository patientRepository;
	
	
	public void createPatient(PatientVO patientVO) {
		if(!StringUtils.isEmpty(patientVO.getId())) {
			throw new RuntimeException("ID should not be populated while creating Patient, passed value "+patientVO.getId());
		}
		patientRepository.save(new Patient(patientVO));
	}
	
	public void updatePatient(PatientVO patientVO) {
		if(StringUtils.isEmpty(patientVO.getId())) {
			throw new RuntimeException("ID should not be empty while updating Patient, passed value "+patientVO.getId());
		}
		Patient existingPatientUpdated = patientRepository.findById(patientVO.getId())
					    .map(d -> new Patient(patientVO))
					    .orElseThrow(() -> new RuntimeException("Patient do not exist with ID "+patientVO.getId()));
		patientRepository.save(existingPatientUpdated);
	}
	
	public List<PatientVO> findAllPatients(){
		return patientRepository.findAll()
						.stream()
						.map(PatientVO::new)
						.collect(Collectors.toList());
	}
	
	public PatientVO findPatient(String idStr){
		return patientRepository.findById(Integer.parseInt(idStr))
			    .map(PatientVO::new)
			    .orElseThrow(() -> new RuntimeException("Patient do not exist with ID "+idStr));
	}
	
	public List<DoctorDTO> findAllDoctorsOfPatient(String idStr){
		Patient patient = patientRepository.findById(Integer.parseInt(idStr))
	    .orElseThrow(() -> new RuntimeException("Patient do not exist with ID "+idStr));
		List<Doctor> doctors = patient.getDoctors();
		if(doctors == null) {
			return new ArrayList<DoctorDTO>();
		}
		return doctors.stream()
			 .map(DoctorDTO::new)
			 .collect(Collectors.toList());
		
	}

	public List<AppointmentDTO> findAllAppointments(String idStr) {
		Patient patient = patientRepository.findById(Integer.parseInt(idStr))
			    .orElseThrow(() -> new RuntimeException("Patient do not exist with ID "+idStr));
				List<Appointment> appointments = patient.getAppointments();
				if(appointments == null) {
					return new ArrayList<>();
				}
				return appointments.stream()
					 .map(AppointmentDTO::new)
					 .collect(Collectors.toList());
	}
	
}

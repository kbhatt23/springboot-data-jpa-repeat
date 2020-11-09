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
import com.learning.jpa.clinic_appointment_service.entities.Speciality;
import com.learning.jpa.clinic_appointment_service.repositories.DoctorRepository;
@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	
	public void createDoctor(DoctorDTO doctorDTO) {
		if(!StringUtils.isEmpty(doctorDTO.getId())) {
			throw new RuntimeException("ID should not be populated while creating Doctor, passed value "+doctorDTO.getId());
		}
		doctorRepository.save(new Doctor(doctorDTO));
	}
	
	public void updateDoctor(DoctorDTO doctorDTO) {
		if(StringUtils.isEmpty(doctorDTO.getId())) {
			throw new RuntimeException("ID should not be empty while updating Doctor, passed value "+doctorDTO.getId());
		}
		Doctor existingDoctorUpdated = doctorRepository.findById(doctorDTO.getId())
					    .map(d -> new Doctor(doctorDTO))
					    .orElseThrow(() -> new RuntimeException("Doctor do not exist with ID "+doctorDTO.getId()));
		doctorRepository.save(existingDoctorUpdated);
	}
	
	public List<DoctorDTO> findAllDoctors(){
		return doctorRepository.findAll()
						.stream()
						.map(DoctorDTO::new)
						.collect(Collectors.toList());
	}
	
	public DoctorDTO findDoctor(String idStr){
		return doctorRepository.findById(Integer.parseInt(idStr))
			    .map(DoctorDTO::new)
			    .orElseThrow(() -> new RuntimeException("Doctor do not exist with ID "+idStr));
	}
	
	public List<DoctorDTO> findDoctorsBySpeciality(Speciality speciality){
		if(speciality==null) {
			return new ArrayList<DoctorDTO>();
		}
		return doctorRepository.findBySpeciality(speciality)
				.stream()
			    .map(DoctorDTO::new)
			    .collect(Collectors.toList());
	}
	
	public List<PatientVO> findAllPatientsOfDoctor(String idStr){
		Doctor findDoctor = doctorRepository.findById(Integer.parseInt(idStr))
										.orElseThrow(() -> new RuntimeException("Doctor do not exist with ID "+idStr));
		List<Patient> patients = findDoctor.getPatients();
		if(patients==null) {
			return new ArrayList<>();
		}
		return patients.stream()
				.map(PatientVO::new)
				.collect(Collectors.toList());
	}
	
	public List<AppointmentDTO> findAllAppointments(String idStr) {
		Doctor doctor = doctorRepository.findById(Integer.parseInt(idStr))
			    .orElseThrow(() -> new RuntimeException("Doctor do not exist with ID "+idStr));
				List<Appointment> appointments = doctor.getAppointments();
				if(appointments == null) {
					return new ArrayList<>();
				}
				return appointments.stream()
					 .map(AppointmentDTO::new)
					 .collect(Collectors.toList());
	}
	
}

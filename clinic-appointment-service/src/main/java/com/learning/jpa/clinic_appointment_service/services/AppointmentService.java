package com.learning.jpa.clinic_appointment_service.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.jpa.clinic_appointment_service.bean.AppointmentDTO;
import com.learning.jpa.clinic_appointment_service.bean.CreateAppointmentVO;
import com.learning.jpa.clinic_appointment_service.bean.DoctorDTO;
import com.learning.jpa.clinic_appointment_service.bean.PatientVO;
import com.learning.jpa.clinic_appointment_service.entities.Appointment;
import com.learning.jpa.clinic_appointment_service.entities.Doctor;
import com.learning.jpa.clinic_appointment_service.entities.Patient;
import com.learning.jpa.clinic_appointment_service.repositories.AppointmentRepository;
import com.learning.jpa.clinic_appointment_service.repositories.DoctorRepository;
import com.learning.jpa.clinic_appointment_service.repositories.PatientRepository;

//not allowing delete appointment as of phase1
@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	public void createAppointment(CreateAppointmentVO createAppointmentVO) {
		//DoctorDTO findDoctor = doctorService.findDoctor(createAppointmentVO.getDoctorID());
		//PatientVO findPatient = patientService.findPatient(createAppointmentVO.getPatientID());
		Appointment appointment = new Appointment(createAppointmentVO);
		//Doctor doctor = new Doctor(findDoctor);
		Doctor doctor = doctorRepository.findById(Integer.parseInt(createAppointmentVO.getDoctorID()))
							.orElseThrow(() -> new RuntimeException("Doctor do not exist with ID "+createAppointmentVO.getDoctorID()));
		doctor.addAppointment(appointment, true);
		
		//Patient patient = new Patient(findPatient);
		Patient patient = patientRepository.findById(Integer.parseInt(createAppointmentVO.getPatientID()))
				.orElseThrow(() -> new RuntimeException("Patient do not exist with ID "+createAppointmentVO.getPatientID()));
		patient.addAppointment(appointment, true);
		appointmentRepository.save(appointment);
	}
	
	public void updateAppintmentDate(String idStr, LocalDateTime newDateTime) {
		appointmentRepository.findById(Integer.parseInt(idStr))
							 .map(a -> {
								 a.setAppointmentDate(newDateTime);
								 return a;
										 })
							 .orElseThrow(() -> new RuntimeException("Appointment do not exist with ID "+idStr))
							 ;
	}
	public AppointmentDTO findAppointMent(String idStr) {
		return appointmentRepository.findById(Integer.parseInt(idStr))
				.map(AppointmentDTO::new)
		 .orElseThrow(() -> new RuntimeException("Appointment do not exist with ID "+idStr))
		;
	}
	
	public void finishAppointment(String idStr) {
		Appointment apporintmnet = appointmentRepository.findById(Integer.parseInt(idStr))
					.map(a -> {a.setCompleted(true);return a;})
					.orElseThrow(() -> new RuntimeException("Appointment do not exist with ID "+idStr));
		appointmentRepository.save(apporintmnet);
		
		
		
	}
}

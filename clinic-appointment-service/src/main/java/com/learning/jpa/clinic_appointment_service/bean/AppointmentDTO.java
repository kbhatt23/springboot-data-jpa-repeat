package com.learning.jpa.clinic_appointment_service.bean;

import java.time.LocalDateTime;

import com.learning.jpa.clinic_appointment_service.entities.Appointment;

public class AppointmentDTO {

	private Integer id;
	
	private LocalDateTime appointmentDate;
	
	private boolean completed;

	private DoctorDTO doctor;
	
	private PatientVO patient;
	
	private String problem;
	
	public AppointmentDTO() {
		
	}
	public AppointmentDTO(Appointment appointment) {
		this.id=appointment.getId();
		this.appointmentDate=appointment.getAppointmentDate();
		this.completed=appointment.isCompleted();
		this.doctor = new DoctorDTO(appointment.getDoctor());
		this.patient = new PatientVO(appointment.getPatient());
		this.problem=appointment.getProblem();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public DoctorDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDTO doctor) {
		this.doctor = doctor;
	}

	public PatientVO getPatient() {
		return patient;
	}

	public void setPatient(PatientVO patient) {
		this.patient = patient;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	
}
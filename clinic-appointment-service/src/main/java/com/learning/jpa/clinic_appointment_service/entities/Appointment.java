package com.learning.jpa.clinic_appointment_service.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.learning.jpa.clinic_appointment_service.bean.CreateAppointmentVO;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime appointmentDate;
	
	private boolean completed;
	//since doctor-appointment is bidirection need to have cascaded form there -> merge
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	//since patient-appointment is bidirection need to have cascaded form there -> merge -> while adding the appointment list to doctor/patient
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	
	private String problem;
	
	public Appointment()
	{
		
	}
	
	public Appointment(CreateAppointmentVO createAppointmentVO) {
		this.appointmentDate=createAppointmentVO.getAppointmentDate();
		this.completed=false;
		this.problem=createAppointmentVO.getProblem();
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}
}

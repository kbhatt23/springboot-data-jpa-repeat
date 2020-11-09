package com.learning.jpa.clinic_appointment_service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.learning.jpa.clinic_appointment_service.bean.PatientVO;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Embedded
	private EmbedableNameBean nameBean;
	
	//join tbale defined in doctor class
	//no cascade needed, cascade will happen using apointment
	//eager fetch as pateint wont have huge doctors
	
	@ManyToMany(mappedBy = "patients", fetch =FetchType.EAGER )
	private List<Doctor> doctors;
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;
	
	public Patient(PatientVO patientVO) {
		this.nameBean=new EmbedableNameBean(patientVO.getFirstName(), patientVO.getLastName());
	}
	
	public Patient() {
		super();
	}

	public void addDoctor(Doctor doctor, boolean updateOnBothSides) {
		if(doctor == null) {
			return;
		}
		if(doctors == null) {
			doctors = new ArrayList<Doctor>();
		}
		doctors.add(doctor);
		if(updateOnBothSides) {
			doctor.addPatient(this, false);
		}
	}
	

	public void addAppointment(Appointment appointment, boolean updateOnBothSides) {
		if(appointment == null) {
			return;
		}
		if(appointments == null) {
			appointments = new ArrayList<Appointment>();
		}
		appointments.add(appointment);
		if(updateOnBothSides)
			appointment.setPatient(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmbedableNameBean getNameBean() {
		return nameBean;
	}

	public void setNameBean(EmbedableNameBean nameBean) {
		this.nameBean = nameBean;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	
	
}

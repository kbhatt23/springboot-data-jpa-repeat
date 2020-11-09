package com.learning.jpa.clinic_appointment_service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.learning.jpa.clinic_appointment_service.bean.DoctorDTO;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Embedded
	private EmbedableNameBean nameBean;
	
	//not stroring as int , as sequence will become imprtant then and hence reduces flexibility
	@Enumerated(EnumType.STRING)
	private Speciality speciality; 
	
	//one doctor can have n numbe rof pateints and oine pateint can allign to multiple doctors
	//apointement entity can merge/update doctors and pateint both, default cascade enough here
	//no cascade needed , lazy fetch is fine as one doctor will have huge patients
	@ManyToMany
	@JoinTable(name = "doctors_patients", joinColumns = @JoinColumn(name="doctor_id",referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="patient_id",referencedColumnName = "id")
			)
	private List<Patient> patients;
	
	//lazy fetch -> one doctor can have huge appointment
	//no cascade on update/delete of doctor no need to remove appointment-> lateron we can modify this
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;
	
	public Doctor() {
		
	}
	public Doctor(DoctorDTO doctorDTO) {
		this.speciality = doctorDTO.getSpeciality();
		this.nameBean = new EmbedableNameBean(doctorDTO.getFirstName(), doctorDTO.getLastName());
	}
	
	public void addPatient(Patient patient, boolean updateOnBothSides) {
		if(patient == null) {
			return;
		}
		if(patients == null) {
			patients = new ArrayList<Patient>();
		}
		patients.add(patient);
		if(updateOnBothSides) {
			patient.addDoctor(this, false);
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
			appointment.setDoctor(this);
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

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	
}

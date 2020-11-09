package com.learning.jpa.clinic_appointment_service.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.clinic_appointment_service.bean.AppointmentDTO;
import com.learning.jpa.clinic_appointment_service.bean.CreateAppointmentVO;
import com.learning.jpa.clinic_appointment_service.services.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/{idStr}")
	public AppointmentDTO findById(@PathVariable String idStr)
	{
	return appointmentService.findAppointMent(idStr);	
	}
	
	@PostMapping
	public void create(@RequestBody CreateAppointmentVO createAppointmentVO) {
		appointmentService.createAppointment(createAppointmentVO);
	}
	
	@PutMapping("/{idStr}/days/{daysStr}")
	public void updateByDay(String daysStr,@PathVariable String idStr) {
		appointmentService.updateAppintmentDate(idStr, LocalDateTime.now().plusDays(Integer.parseInt(daysStr)));
	}
	
	@GetMapping("/{idStr}/finish")
	public void finishAppointment(@PathVariable String idStr) {
		appointmentService.finishAppointment(idStr);
	}
}

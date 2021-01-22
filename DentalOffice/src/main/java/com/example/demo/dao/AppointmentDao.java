package com.example.demo.dao;

import java.util.List;
import java.util.Optional;


import com.example.demo.model.Appointment;

public interface AppointmentDao {
	void createAppointment(Appointment appointment);
	
	
	List<Appointment> getAllAppointment();
	Optional<Appointment> getAppointmentById(int id);
	List<Appointment> getAppointmentByUserId(int id);
	List<Appointment> getAppointmentByDentalId(int id);
	Optional<Appointment> getByDentalAndUserId(int idDental, int idUser);
	
	void deleteAppointmentById(int id);
	void deleteAppointmentAll();
}

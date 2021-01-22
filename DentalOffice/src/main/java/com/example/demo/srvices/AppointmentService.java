package com.example.demo.srvices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AppointmentDao;
import com.example.demo.model.Appointment;

@Service
public class AppointmentService {
	private final AppointmentDao appointmentDao;
	
	@Autowired
	public AppointmentService(@Qualifier("appointmentDao") AppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}
	
	public void add(Appointment appointment) {
		appointmentDao.createAppointment(appointment);
	}
	
	public List<Appointment> getAll(){
		return appointmentDao.getAllAppointment();
	}
	
	public Optional<Appointment> getById(int id){
		return appointmentDao.getAppointmentById(id);
	}
	
	public List<Appointment> getByUserId(int id){
		return appointmentDao.getAppointmentByUserId(id);
	}
	
	public List<Appointment> getByDentalId(int id){
		return appointmentDao.getAppointmentByDentalId(id);
	}
	
	public Optional<Appointment> getByDenalAndUserId(int idDental, int idUser){
		return appointmentDao.getByDentalAndUserId(idDental, idUser);
	}
	
	public void deleteById(int id) {
		appointmentDao.deleteAppointmentById(id);
	}
	
	public void deleteAll() {
		appointmentDao.deleteAppointmentAll();
	}
}

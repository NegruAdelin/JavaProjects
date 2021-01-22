package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;



@Repository("appointmentDao")
public class AppointmentDaoImp implements AppointmentDao {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Override
	public void createAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		List<Appointment> listAppointment = appointmentRepository.findAll();
		
		if(listAppointment.isEmpty())
			return null;
		else
			return listAppointment;
	}

	@Override
	public Optional<Appointment> getAppointmentById(int id) {
		Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
		return optionalAppointment;
	}

	@Override
	public List<Appointment> getAppointmentByUserId(int id) {
		
		List<Appointment> optionalAppointment = appointmentRepository.findByUserId(id);
		return optionalAppointment;
	}


	@Override
	public void deleteAppointmentById(int id) {
		appointmentRepository.deleteById(id);
	}

	@Override
	public void deleteAppointmentAll() {
		appointmentRepository.deleteAll();
	}

	@Override
	public List<Appointment> getAppointmentByDentalId(int id) {
		return appointmentRepository.findByDentalId(id);
	}

	@Override
	public Optional<Appointment> getByDentalAndUserId(int idDental, int idUser) {
		return appointmentRepository.getByDentalAndUserId(idDental, idUser);
	}

}

package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query(value = "SELECT * FROM appointment a WHERE a.user_id = :id ",
			nativeQuery = true)
	public List<Appointment> findByUserId(@Param("id") int id);
	
	@Query(value = "SELECT * FROM appointment a WHERE a.dental_office_id = :id ",
			nativeQuery = true)
	public List<Appointment> findByDentalId(@Param("id") int id);
	
	@Query(value = "SELECT a FROM appointment a WHERE a.dental_office_id = :idDental AND a.user_id = :idUser", 
			nativeQuery = true)
	public Optional<Appointment> getByDentalAndUserId(@Param("idDental") int idDental,
													   @Param("idUser") int idUser);
}

package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.DentalOffice;

public interface DentalOfficeRepository extends JpaRepository<DentalOffice, Integer> {
	@Query("SELECT d FROM dental_office d WHERE d.email = :email")
	Optional<DentalOffice> getByEmail(@Param(value = "email") String email);
}

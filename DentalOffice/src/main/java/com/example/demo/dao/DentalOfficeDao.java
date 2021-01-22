package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.DentalOffice;

public interface DentalOfficeDao {
	void createDentalOffice(DentalOffice dentalOffice);
	
	Optional<DentalOffice> getDentalOfficeById(int id);
	List<DentalOffice> getAllDentalOffice();
	Optional<DentalOffice> getByEmail(String email);
	
	void updateDentalOffice(DentalOffice dentalOffice);
	
	void deleteDentalOfficeById(int id);
	void deleteAllDentalOffice();
}

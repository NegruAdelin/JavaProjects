package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DentalOffice;
import com.example.demo.repository.DentalOfficeRepository;

@Repository("dentalOfficeDao")
public class DentalOfficeDaoImp implements DentalOfficeDao {
	
	@Autowired
	private DentalOfficeRepository dentalOfficeRepository;
	

	@Override
	public void createDentalOffice(DentalOffice dentalOffice) {
		dentalOfficeRepository.save(dentalOffice);
	}

	@Override
	public Optional<DentalOffice> getDentalOfficeById(int id) {
		return  dentalOfficeRepository.findById(id);
	}

	@Override
	public List<DentalOffice> getAllDentalOffice() {
		return dentalOfficeRepository.findAll();
	}

	@Override
	public void updateDentalOffice(DentalOffice dentalOffice) {		
		dentalOfficeRepository.save(dentalOffice);
	}

	@Override
	public void deleteDentalOfficeById(int id) {
		dentalOfficeRepository.deleteById(id);
	}

	@Override
	public void deleteAllDentalOffice() {
		dentalOfficeRepository.deleteAll();
	}
	
	@Override
	public Optional<DentalOffice> getByEmail(String email){
		return dentalOfficeRepository.getByEmail(email);
	}
}

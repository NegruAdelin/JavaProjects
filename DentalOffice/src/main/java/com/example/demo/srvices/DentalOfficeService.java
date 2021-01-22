package com.example.demo.srvices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DentalOfficeDao;
import com.example.demo.model.DentalOffice;

@Service
public class DentalOfficeService {
	private final DentalOfficeDao dentalOfficeDao;
	
	@Autowired
	public DentalOfficeService(@Qualifier("dentalOfficeDao") DentalOfficeDao dentalOfficeDao) {
		this.dentalOfficeDao = dentalOfficeDao;
	}
	
	public void add(DentalOffice dentalOffice) {
		dentalOfficeDao.createDentalOffice(dentalOffice);
	}
	
	public Optional<DentalOffice> getById(int id){
		return dentalOfficeDao.getDentalOfficeById(id);
	}
	
	public List<DentalOffice> getAll(){
		return dentalOfficeDao.getAllDentalOffice();
	}
	
	public void update(DentalOffice dentalOffice) {
		dentalOfficeDao.updateDentalOffice(dentalOffice);
	}
	
	public void deleteById(int id) {
		dentalOfficeDao.deleteDentalOfficeById(id);
	}
	
	public void deleteAll() {
		dentalOfficeDao.deleteAllDentalOffice();
	}
	
	public Optional<DentalOffice> getByEmail(String email){
		return dentalOfficeDao.getByEmail(email);
	}
}

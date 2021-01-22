package com.example.demo.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "dental_office")
@Table(
		uniqueConstraints = {
				@UniqueConstraint(name = "dental_office_constraint", columnNames ="dental_office_email")
		})
public class DentalOffice {
	@Id
	@SequenceGenerator(
			name = "generator_dentalOffice",
			sequenceName = "table_generator_dentalOffice",
			allocationSize = 1)
	@GeneratedValue(
			generator = "generator_dentalOffice",
			strategy = SEQUENCE)
	@Column(
			name = "dental_office_id",
			nullable = false,
			updatable = false)
	private int id;
	
	@Column(
			name = "dental_office_name",
			nullable = false,
			columnDefinition = "TEXT")
	private String name;
	
	@Column(
			name = "dental_office_phone",
			nullable = false,
			columnDefinition = "TEXT")
	private String phone;
	
	@Column(
			name = "dental_office_email",
			nullable = false,
			columnDefinition = "TEXT")
	private String email;
	
	@Column(
			name = "dental_office_address",
			nullable = false,
			columnDefinition = "TEXT")
	private String address;
	
	@Column(
			name = "dental_office_password",
			nullable = false,
			columnDefinition = "TEXT")
	private String password;
	
	private DentalOffice() {
	}
	
	private DentalOffice(int id, String name, String phone, String email, String address, 
			String password) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}		
}

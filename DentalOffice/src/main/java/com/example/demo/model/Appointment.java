package com.example.demo.model;

import static javax.persistence.GenerationType.SEQUENCE;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "appointment")
public class Appointment {
	@Id
	@SequenceGenerator(
			name = "generator_appointment",
			sequenceName = "table_generator_appointment",
			allocationSize = 1)
	@GeneratedValue(
			generator = "generator_appointment",
			strategy = SEQUENCE)
	@Column(
			name = "appointment_id",
			nullable = false,
			updatable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName="user_id", foreignKey=@ForeignKey(name = "FK_User"))
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "dental_office_id", referencedColumnName="dental_office_id", foreignKey=@ForeignKey(name = "FK_Dental_Office"))
	private DentalOffice dental_office;
	
	@Column(
			name = "appointment_date",
			nullable = false,
			columnDefinition = "TEXT")
	private String date;
	
	public Appointment() {
	}
	
	
	
	public Appointment(User user, DentalOffice dental_office, String date) {
		this.user = user;
		this.dental_office = dental_office;
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DentalOffice getDental_office() {
		return dental_office;
	}

	public void setDental_office(DentalOffice dental_office) {
		this.dental_office = dental_office;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}

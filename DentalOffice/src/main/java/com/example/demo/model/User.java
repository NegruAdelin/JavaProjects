package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name = "user_dental_office")
@Table(
		uniqueConstraints = {
				@UniqueConstraint(name = "user_email_constraint", columnNames = "user_email")
		}
)
public class User {
	@Id
	@SequenceGenerator(
			name = "generator_user",
			sequenceName = "table_generator_user",
			allocationSize = 1)
	@GeneratedValue(
			generator = "generator_user",
			strategy = SEQUENCE)
	@Column(
			name = "user_id",
			nullable = false,
			updatable = false)
	private int id;
	
	@Column(
			name = "user_name",
			nullable = false,
			columnDefinition = "TEXT")
	private String name;
	
	@Column(
			name = "user_email",
			nullable = false,
			columnDefinition = "TEXT")
	private String email;
	
	@Column(
			name = "user_password",
			nullable = false,
			columnDefinition = "TEXT")
	private String password;
	
	@Column(
			name = "user_phone",
			nullable = false,
			columnDefinition = "TEXT")
	private String phone;
	
	public User() {
	}
	
	public User(int id,
				String name,
				String email,
				String password,
				String phone) {
	
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

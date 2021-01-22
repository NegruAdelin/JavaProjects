package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserDao {
	void createtUser(User user);
	
	
	List<User> getAllUsers();
	Optional<User> getUserById(int id);
	Optional<User> getByEmail(String email);
	void updateUser(User user);
	
	void deleteUserById(int id);	
	void deleteAllUsers();
	
}

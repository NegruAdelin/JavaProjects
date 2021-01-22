package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Repository("userDao")
public class UserDaoImp implements UserDao {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createtUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> lsitUser = userRepository.findAll();
		
		if(lsitUser.isEmpty())
			return null;
		else
			return lsitUser;
	}

	@Override
	public Optional<User> getUserById(int id) {
		Optional<User> optionalUser = userRepository.findById(id);
		
		return optionalUser;
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	public Optional<User> getByEmail(String email) {
		return userRepository.getByEmail(email);
	}
}

package com.example.demo.srvices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserService {
	private final UserDao userDao;
	
	@Autowired
	public UserService (@Qualifier("userDao") UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add(User user) {
		
		userDao.createtUser(user);
	}
	
	public List<User> getAll(){
		return userDao.getAllUsers();
	}
	
	public Optional<User> getById(int id){
		return userDao.getUserById(id);
	}
	
	public Optional<User> getByEmail(String email){
		return userDao.getByEmail(email);
	}
	
	public void update(User user) {
		userDao.updateUser(user);
	}
	
	public void deleteById(int id) {
		userDao.deleteUserById(id);
	}
	
	public void deleteAll() {
		userDao.deleteAllUsers();
	}
}

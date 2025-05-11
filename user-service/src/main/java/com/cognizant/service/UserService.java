package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepo;



@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAllUser() {
		return userRepo.findAll();
	}
	
	public ResponseEntity<String> deleteUserById(Long id){
		userRepo.deleteById(id);
		return new ResponseEntity<>("User deleted successfully..", HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteAllUsers(){
		userRepo.deleteAll();
		return new ResponseEntity<>("All Users Deleted Successfully..", HttpStatus.OK);
	}
	
	public ResponseEntity<User> updateUser(User user){
		return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
	}
}

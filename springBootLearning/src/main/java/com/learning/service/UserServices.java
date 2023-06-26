package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Users;
import com.learning.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;

	public List<Users> findAll() {
		
		return repository.findAll();
	}

	public Users findById(int id) {
		
		return repository.findById(id).get();
		}

	public void deleteById(int id) {
		
		repository.deleteById(id);
	}

	public Users save( Users user) {
		
		return repository.save(user);
	}
	
	
	
}

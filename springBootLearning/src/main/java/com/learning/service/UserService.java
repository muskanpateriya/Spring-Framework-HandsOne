package com.learning.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.learning.entity.Users;

@Service
public class UserService {

	private static List<Users> users;

	private static int countId = 0;
	
	static {
		users = new ArrayList<>();
		users.add(new Users(++countId, "Muskan Pateriya", LocalDate.now().minusYears(23)));
		users.add(new Users(++countId, "Vidhi Pateriya", LocalDate.now().minusYears(24)));
		users.add(new Users(++countId, "Vaishnavi Pateriya", LocalDate.now().minusYears(22)));
	}

	public List<Users> findAll() {
		return users;
	}

	public Users save(Users user) {

		user.setId(++countId);
		users.add(user);
		return user;

	}

	public Users findById(int id) {

		return users.stream().filter(user -> user.getId() == id).findFirst().get();
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		
		
	}

}

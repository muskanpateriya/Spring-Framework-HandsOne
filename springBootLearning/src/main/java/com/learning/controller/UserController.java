package com.learning.controller;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.entity.Users;
import com.learning.exception.UserNotFoundException;
import com.learning.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<Users> getAllUsers() {

		return service.findAll();
	}

	@PostMapping("/users")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {

		Users createdUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest() // http://localhost:8080/users
				.path("/{id}")                                         // http://localhost:8080/users/{id}
				.buildAndExpand(createdUser.getId())                  // http://localhost:8080/users/4
				.toUri();                                            // http://localhost:8080/users/4
		return ResponseEntity.created(location).build();            // Sending created 201 status ialong with the location of created resource

	}


	@GetMapping("/users/{id}")
	public EntityModel<Users> retrieveUser(@PathVariable int id) {
		Users user = service.findById(id);
		
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		
		EntityModel<Users> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
}

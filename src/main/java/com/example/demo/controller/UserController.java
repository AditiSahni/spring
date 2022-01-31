package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;

import com.example.demo.handler.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.userservice.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	//UserValidation userValidation = new UserValidation();

	@PostMapping("/save")
	public ResponseEntity addUser(@RequestBody UserDto user) throws NotFoundException {
		userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/update")
	public ResponseEntity updateUser(@RequestBody UserDto user) throws NotFoundException {
		userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/{name}")
	public User getUserByName(@PathVariable String name) throws NotFoundException {

		return userService.getUser(name);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable String id) {
		logger.info("Inside Controller's Delete User Method {}", id);
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}

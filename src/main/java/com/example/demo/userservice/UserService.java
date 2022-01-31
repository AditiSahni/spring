package com.example.demo.userservice;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDto;
//import com.example.demo.handler.EmptyInputException;
import com.example.demo.handler.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public User addUser(UserDto userDto) throws NotFoundException {

		User user = UserConverter.dtoToEntity(userDto);
		if (user.getUserName().isEmpty()) {
			throw new NotFoundException("Please enter Name");
		}
		if(user.getUserName().length()<3) {
			throw new NotFoundException("Name length should be more than 2 chracters");
		}
		return userRepository.insert(user);
	}

	public void updateUser(UserDto userDto) throws NotFoundException {

		User user = UserConverter.dtoToEntity(userDto);
		if (user.getUserName().isEmpty()) {
			throw new NotFoundException("Please enter Name");
		}
		if(user.getUserName().length()<3) {
			throw new NotFoundException("Name length should be more than 2 characters");
		}

		userRepository.save(user);
	}

	public User getUser(String name) throws NotFoundException {
		User user = null;
		try {
			user = userRepository.findByName(name).get();
		} catch (Exception e) {
			throw new NotFoundException("User not found");
		}
		return user;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(String id) {
		logger.info("Inside Service Delete User Method {}", id);
		userRepository.deleteById(id);
	}
}

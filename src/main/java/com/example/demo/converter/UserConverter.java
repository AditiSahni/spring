package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

@Component
public class UserConverter {

	public static UserDto entitytoDto(User user) {
		UserDto dto = new UserDto();
		dto.setUserName(user.getUserName());
		dto.setUserDepartment(user.getUserDepartment());
		dto.setUserSalary(user.getUserSalary());

		return dto;
	}

	public static User dtoToEntity(UserDto dto) {
		User user = new User();
		user.setUserName(dto.getUserName());
		user.setUserDepartment(dto.getUserDepartment());
		user.setUserSalary(dto.getUserSalary());

		return user;
	}
}

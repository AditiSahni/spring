package com.example.demo.dto;

import java.math.BigDecimal;

import com.example.demo.model.UserDepartment;

import lombok.Data;

@Data
public class UserDto {
	private String userName;
	private UserDepartment userDepartment;
	private BigDecimal userSalary;

}

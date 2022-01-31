package com.example.demo.model;

import java.math.BigDecimal;

//import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("user")
public class User {
	@Id
	private String id;

	@Field("name")
	//@Size(min = 3)
	private String userName;

	@NotNull(message = "Department is mandatory")
	@Field("department")
	private UserDepartment userDepartment;

	@Pattern(regexp = "/^[0-9]+$/")
	@Field("salary")
	private BigDecimal userSalary;

}

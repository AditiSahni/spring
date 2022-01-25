package com.example.demo.model;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
	    @Indexed(unique = true)
	    private String userName;
	   
	    @Field("department")
	    private UserDepartment userDepartment;
	    @Field("salary")
	    private BigDecimal userSalary;
	
	

}


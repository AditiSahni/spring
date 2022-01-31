package com.example.demo.handler;

import java.net.http.HttpHeaders;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//import com.example.demo.userservice.UserService;

@ControllerAdvice
public class MyControllerAdvice {

	Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<UserError> mapEmptyInputException(EmptyInputException emptyInputException) {
		UserError error = new UserError(HttpStatus.NO_CONTENT.value(), emptyInputException.getMessage());
		logger.info("Inside Controller Advice{}", emptyInputException.getMessage());
		return new ResponseEntity<UserError>(error, HttpStatus.NO_CONTENT);

	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<UserError> mapException(NotFoundException ex) {
		UserError error = new UserError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<UserError>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException) {
		return new ResponseEntity<String>("No Such Value found in DB,Please change your request", HttpStatus.NOT_FOUND);

	}

	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("Please change your http method type", HttpStatus.NOT_FOUND);
	}

}

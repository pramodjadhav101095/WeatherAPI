package com.prowings.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prowings.weather.responsedto.model.CustomException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidURLException.class)
	public ResponseEntity<String> invalideUrlExceptionHandler(InvalidURLException ex){
		
		System.out.println("Inside global exception handler");
		
		CustomException error = new CustomException();
		
		error.setMessage(ex.getMessage());
		error.setRoot("abc");
		error.setStatuscode(400);
		
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		
	}

}

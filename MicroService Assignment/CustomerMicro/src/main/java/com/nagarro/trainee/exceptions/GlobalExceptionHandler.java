package com.nagarro.trainee.exceptions;

import com.nagarro.trainee.payload.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse ar = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(ar, HttpStatus.NOT_FOUND);
	}

}

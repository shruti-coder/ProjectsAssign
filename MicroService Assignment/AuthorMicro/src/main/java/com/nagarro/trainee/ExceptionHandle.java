package com.nagarro.trainee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionHandle {
	@ExceptionHandler
	public ResponseEntity<Object> exceptionHandle(Exception e){
		Map<String,Object> mp=new HashMap<>();
		mp.put("message", e.getMessage());
		return new ResponseEntity<Object>(mp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}

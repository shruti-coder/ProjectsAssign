package com.nagarro.controller;
import java.util.HashMap;
import java.util.Map;

import com.nagarro.model.User;
import com.nagarro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/users/signin")
	public Object signup(@RequestBody User user) {
		Map<String,Object> respo=new HashMap<>();
		if(userService.isAuth(user)) {
		respo.put("msg", "User Successfully Authenticated");
		respo.put("isAuth", true);
		}
		else {
			respo.put("msg", "User UnAuthneticated");
			respo.put("isAuth", false);
			
		}
		return respo;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		int status = userService.addUser(user);
		Map<String,Object> respo=new HashMap<>();
		
		if (status == 1) {
			respo.put("msg","User Added Successfully")	;		
			return new ResponseEntity<>(respo, HttpStatus.CREATED);
		}
		else {
			respo.put("msg","User Already Exist");
			return new ResponseEntity<>(respo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
}

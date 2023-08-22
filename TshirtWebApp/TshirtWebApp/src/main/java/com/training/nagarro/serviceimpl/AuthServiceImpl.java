package com.training.nagarro.serviceimpl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.training.nagarro.dao.AuthDao;
import com.training.nagarro.model.User;
import com.training.nagarro.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
/*
 * Encode Base64.getEncoder().encodeToString(user.getPassword().getBytes(StandardCharsets.UTF_8));
 * new String(Decode Base64.getDecoder().decode(user.getPassword()));
 */
	@Autowired
	private AuthDao ad;
	
	public int addUser(User user) {
		
		String encryptedPass=Base64.getEncoder().encodeToString(user.getPassword().getBytes(StandardCharsets.UTF_8));
		user.setPassword(encryptedPass);
		ad.registerUser(user);
		return 1;
	}


	/* (non-Javadoc)
	 * @see com.training.nagarro.service.AuthService#validateUser(com.training.nagarro.model.User)
	 */
	public boolean validateUser(User user) {
		String encryptedPass=Base64.getEncoder().encodeToString(user.getPassword().getBytes(StandardCharsets.UTF_8));
		user.setPassword(encryptedPass);
		return ad.isAuthenticated(user);
	}


}

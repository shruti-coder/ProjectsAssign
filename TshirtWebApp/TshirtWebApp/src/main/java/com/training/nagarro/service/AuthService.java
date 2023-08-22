package com.training.nagarro.service;

import com.training.nagarro.model.User;

/**
 * Auth Service
 */
public interface AuthService {
	/**
	 * @param user
	 * @return status
	 */
	int addUser(User user);
	/**
	 * @param user
	 * @return true/false
	 */
	boolean validateUser(User user);
}

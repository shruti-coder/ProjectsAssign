package com.training.nagarro.dao;

import com.training.nagarro.model.User;

/**
 * get User Authentication Tasks
 */
public interface AuthDao {

	/**
	 * @param user
	 * @return status
	 */
	int registerUser(User user);
	
	/**
	 * @param user
	 * @return true/false
	 */
	boolean isAuthenticated(User user); 
}

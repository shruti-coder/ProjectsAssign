package com.training.nagarro.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Controller;

/**
 * User Bean
 */
@Entity
@Controller
@Table(name="user")
public class User {
	/**
	 *Username
	 */
	@Id
	@NotBlank(message = "Required")
	@Size(min = 3, max = 12, message = "Name must be min 3-12 characters")
	@Column(name="username")
	private String username;

	/**
	 *password
	 */
	@NotBlank(message = "Required")
	@Size(min = 3, max = 12, message = "Password must be min 3-12 characters")
	@Column(name="password")
	private String password;

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	/**
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}

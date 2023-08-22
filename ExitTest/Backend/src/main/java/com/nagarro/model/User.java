package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String email;
private String firstName;
private String lastName;
private String password;
/*****************Setter and Getter******************************/
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
 /*************Default Constructor***********************/
public User() {
	super();
	//TODO Auto-generated constructor stub
}
public User(int id, String firstName, String lastName, String email, String password) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
}


}

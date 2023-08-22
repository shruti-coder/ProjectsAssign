package com.nagarro.trainee.service;

import java.util.List;

import com.nagarro.trainee.entity.Customer;

import org.springframework.stereotype.Service;
@Service
public interface CustomerService {
	//Customer
	
	//get all customer
	public List<Customer> getCustomer();
	
	//get single customer by Customerid
	public Customer getCustomerId(int id);
	
	//create Customer
	public Customer addCustomer(Customer customer);
	
	//Update Customer
	public Customer updateCustomer(Customer customer);
	
	//Delete Customer
	public void deleteCourse(int id);
	
}

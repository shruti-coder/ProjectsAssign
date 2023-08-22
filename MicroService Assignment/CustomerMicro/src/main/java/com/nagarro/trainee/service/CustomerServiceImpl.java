package com.nagarro.trainee.service;

import java.util.List;

import com.nagarro.trainee.dao.CustomerDao;
import com.nagarro.trainee.entity.Customer;
import com.nagarro.trainee.exceptions.ResourceNotFoundException;
import com.nagarro.trainee.restModels.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerdao;
	
	@Override
	public List<Customer> getCustomer() {
		
		return customerdao.findAll();
	}

	@Override
	public Customer getCustomerId(int id) {
		Customer customer=customerdao.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not found" +id));
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerdao.save(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stu
		return customerdao.save(customer);
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		customerdao.deleteById(id);
	}

}

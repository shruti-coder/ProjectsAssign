package com.nagarro.trainee.controller;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.trainee.entity.Customer;
import com.nagarro.trainee.restModels.Account;
import com.nagarro.trainee.restModels.CustomerRes;
import com.nagarro.trainee.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private RestTemplate rest;

	private static final String URL = "http://Account-Service/account";

// Getting All Customer Details	
	@GetMapping
	public List<CustomerRes> getCustomers() {
		List<CustomerRes> result = new ArrayList<>();
		this.customerservice.getCustomer().stream().forEach(customer -> {
			CustomerRes cr = CustomerRes.builder().name(customer.getName())
					.accounts(getAccountsByUserId(customer.getUserid())).userid(customer.getUserid())
					.phone(customer.getPhone()).build();
			result.add(cr);
		});
		return result;
	}

//Getting Customer Details By Id
	@GetMapping("/{customerId}")
	public CustomerRes getCustomerId(@PathVariable String customerId) {
		Customer customer = this.customerservice.getCustomerId(Integer.parseInt(customerId));
		return CustomerRes.builder().name(customer.getName())
				.accounts(getAccountsByUserId(Integer.parseInt(customerId))).userid(customer.getUserid())
				.phone(customer.getPhone()).build();
	}

//Adding New Customer
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.customerservice.addCustomer(customer);
	}

//Updating Customer
	@PutMapping("/{customerId}")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return this.customerservice.updateCustomer(customer);
	}

//Deleting the Customer
	@DeleteMapping("/{customerId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String customerId) {
//		try {
//			int id=Integer.parseInt(customerId);
//			this.getAccountsByUserId(id).stream().forEach( acc->{
//				rest.delete(URL+"/customer/"+acc.getAccid());
//			});
//			this.customerservice.deleteCourse(id);
//			return new ResponseEntity<>(HttpStatus.OK);
		
		int id=Integer.parseInt(customerId);	
		this.customerservice.deleteCourse(id);
		try {
			this.getAccountsByUserId(id).stream().forEach(acc->{
				rest.delete(URL+"/customer/"+acc.getAccid());
			this.customerservice.deleteCourse(id);
			});
			return new ResponseEntity<>(HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<Account> getAccountsByUserId(int id) {
		return rest.getForObject(URL + "/" + id, List.class);
	}

}

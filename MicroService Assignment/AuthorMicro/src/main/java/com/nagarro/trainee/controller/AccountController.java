package com.nagarro.trainee.controller;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.trainee.dto.AccountRes;
import com.nagarro.trainee.dto.Customer;
import com.nagarro.trainee.entity.Account;
import com.nagarro.trainee.service.AccountService;

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
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private RestTemplate rest;
	private static final String URL = "http://User-Service/customer";

	@Autowired
	private AccountService accountService;

	@GetMapping("/customer")
	public List<AccountRes> getAccount() {
		List<AccountRes> ar = new ArrayList<>();
		this.accountService.getAccount().stream().forEach(acc->{
			AccountRes a= AccountRes.builder().accId(acc.getAccid()).accountNo(acc.getAccountNo()).amount(acc.getAmount())
					.customer(getByuserId(acc.getUserId())).build();
			ar.add(a);
			
		});
		return ar;
	}

	@GetMapping("/customer/{accid}")
	public AccountRes getAccountById(@PathVariable String accid) {
		Account acc = this.accountService.getAccountById(Integer.parseInt(accid));
		return AccountRes.builder().accId(acc.getAccid()).accountNo(acc.getAccountNo()).amount(acc.getAmount())
				.customer(getByuserId(acc.getUserId())).build();
	}

	@GetMapping("/{customerId}")
	public List<Account> getAccountsByCustomerId(@PathVariable int customerId) {
		return this.accountService.getAccountByCustomerId(customerId);
	}

	@PostMapping("/customer")
	public Account addAccount(@RequestBody Account account) {
		return this.accountService.addAccount(account);
	}

	@PutMapping("/customer/{accountid}")
	public Account updateAccount(@RequestBody Account account) {
		return this.accountService.updateAccount(account);
	}

	@PostMapping("/customer/deposit")
	public Account deposit(@RequestBody Account account) {
		return this.accountService.deposit(account);
	}

	@PostMapping("/customer/withdrawl")
	public Account withdrawl(@RequestBody Account account) {
		return this.accountService.withdrawl(account);
	}

	@DeleteMapping("/customer/{accountId}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable String accountId) {
		try {
			this.accountService.deleteAccount(Integer.parseInt(accountId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public Customer getByuserId(int id) {
		return rest.getForObject(URL + "/" + id, Customer.class);
	}
}

package com.nagarro.trainee.service;

import java.util.List;

import com.nagarro.trainee.entity.Account;

public interface AccountService {

	public List<Account> getAccount();
	public Account getAccountById(int accid);
	public Account addAccount(Account account);
	public Account updateAccount(Account account);
	public void deleteAccount(int id);
	public List<Account> getAccountByCustomerId(int customerId);
	public Account deposit(Account account);
	public Account withdrawl(Account account);
}

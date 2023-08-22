package com.nagarro.trainee.service;

import java.util.List;
import java.util.Objects;

import com.nagarro.trainee.dao.AccountDao;
import com.nagarro.trainee.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountdao;

	@Override
	public List<Account> getAccount() {
		// TODO Auto-generated method stub
		return accountdao.findAll();
	}

	@Override
	public Account getAccountById(int userid) {
		// TODO Auto-generated method stub
		return accountdao.findById(userid).orElse(null);
	}

	@Override
	public Account addAccount(Account account) {
		return accountdao.save(account);

	}

	@Override
	public Account updateAccount(Account account) {
		return accountdao.save(account);
	}

	@Override
	public void deleteAccount(int id) {
		accountdao.deleteById(id);
	}

	@Override
	public List<Account> getAccountByCustomerId(int customerId) {
		return accountdao.findByUserId(customerId);
	}

	@Override
	public Account deposit(Account account) {
		Account findFromDb = accountdao.findByAccountNoAndUserId(account.getAccountNo(), account.getUserId());
		if (Objects.isNull(findFromDb)) {
			throw new RuntimeException("account Not Found");
		}
		if (account.getAmount() >= 0) {
			findFromDb.setAmount(findFromDb.getAmount() + account.getAmount());
		}
		else {
			throw new RuntimeException("Invalid amount");
		}
		return accountdao.save(findFromDb);
	}

	@Override
	public Account withdrawl(Account account) {
		Account findFromDb = accountdao.findByAccountNoAndUserId(account.getAccountNo(), account.getUserId());
		if (Objects.isNull(findFromDb)) {
			throw new RuntimeException("account Not Found");
		}
		if (findFromDb.getAmount()- account.getAmount()  > 0) {
			findFromDb.setAmount(findFromDb.getAmount() - account.getAmount());
		}
		else {
			throw new RuntimeException("Insufficient balance");
		}
		return accountdao.save(findFromDb);
	}

}

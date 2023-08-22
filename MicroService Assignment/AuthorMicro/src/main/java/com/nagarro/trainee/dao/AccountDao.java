package com.nagarro.trainee.dao;

import java.util.List;

import com.nagarro.trainee.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

	List<Account> findByUserId(int id);
	Account findByAccountNoAndUserId(String accountNo,int id);
}

package com.nagarro.trainee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRes {
	private int accId;
	private String accountNo;
	private double amount;
	private Customer customer;
}

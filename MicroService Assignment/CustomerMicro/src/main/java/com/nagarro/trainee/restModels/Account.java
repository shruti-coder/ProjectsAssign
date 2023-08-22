package com.nagarro.trainee.restModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	private int accid;
	private String accountNo;
	private double amount;
	private int userId;
}

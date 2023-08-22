package com.nagarro.trainee.restModels;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRes {
	private int userid;
	private String name;
	private long phone;
	private List<Account> accounts;
}
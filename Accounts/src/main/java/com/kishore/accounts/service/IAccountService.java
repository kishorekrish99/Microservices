package com.kishore.accounts.service;

import com.kishore.accounts.dto.CustomerDto;

public interface IAccountService {

	
	void createAccount(CustomerDto customerDto);

	CustomerDto fetchAccount(String mobileNumber);
	
	boolean updateAccount(CustomerDto customerDto);

	boolean deleteAccount(String mobileNumber);
}

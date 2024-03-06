package com.kishore.accounts.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishore.accounts.Constants.AccountsConstants;
import com.kishore.accounts.Mapper.AccountsMapper;
import com.kishore.accounts.Mapper.CustomerMapper;
import com.kishore.accounts.Repository.AccountRepository;
import com.kishore.accounts.Repository.CustomerRepository;
import com.kishore.accounts.dto.AccountsDto;
import com.kishore.accounts.dto.CustomerDto;
import com.kishore.accounts.entity.Accounts;
import com.kishore.accounts.entity.Customer;
import com.kishore.accounts.exception.CustomerAlreadyExistException;
import com.kishore.accounts.exception.ResourceNotFoundException;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public void createAccount(CustomerDto customerDto) {
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
		if(optionalCustomer.isPresent()) {
			throw new CustomerAlreadyExistException("The customer with the mobile number: "+ customer.getMobileNumber()+" is already Exists");
		}
		Customer savedCustomer = customerRepository.save(customer);
		accountRepository.save( createNewAccount(savedCustomer) );
	}
	
	private Accounts createNewAccount(Customer customer) {
		Accounts newAccount = new Accounts();
		newAccount.setCustomerId(customer.getCustomerId());
		long randomAccNumber = 100000000L + new Random().nextInt(90000000);
		newAccount.setAccountType(AccountsConstants.SAVINGS);
		newAccount.setAccountNumber(randomAccNumber);
		newAccount.setBranchAddress(AccountsConstants.ADDRESS);
		
		return newAccount;
		
	}

	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()-> new ResourceNotFoundException("Customer","MobileNumber",mobileNumber) 
				);
		Accounts account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Account","customerId",customer.getCreatedBy().toString())
				);
		
		CustomerDto customerdto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
		customerdto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
		return customerdto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		 boolean isUpdated = false;
	        AccountsDto accountsDto = customerDto.getAccountsDto();
	        if(accountsDto !=null ){
	            Accounts accounts = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
	                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
	            );
	            AccountsMapper.mapToAccounts(accountsDto, accounts);
	            accounts = accountRepository.save(accounts);

	            Long customerId = accounts.getCustomerId();
	            Customer customer = customerRepository.findById(customerId).orElseThrow(
	                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
	            );
	            CustomerMapper.mapToCustomer(customerDto,customer);
	            customerRepository.save(customer);
	            isUpdated = true;
	        }
	        return  isUpdated;
	}

	@Override
	public boolean deleteAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
				);
		accountRepository.deleteByCustomerId(customer.getCustomerId());
		customerRepository.deleteById(customer.getCustomerId());
		return true;
	}

}

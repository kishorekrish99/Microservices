package com.kishore.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {
	
	@Schema(description = "Name of the customer", example = "Kishore Uputoori")
	@NotEmpty(message="Name cannot be null or empty")
	@Size(min = 5, max=30, message="The length of the customer should be between 5 and 30")
	private String name;
	
	@Schema(description = "Email address of the customer", example = "kishoreuputoori@gmail.com.com")
	@NotEmpty(message="email address cannot be empty")
	@Email(message="Email address should be a valid value")
	private String email;
	
	@Schema(description = "Mobile Number of the customer", example = "9345432123")
	@Pattern(regexp="(^$|[0-9]{10})",message="mobile number must be 10 digits")
	private String mobileNumber;
	  
	@Schema(description = "Account details of the Customer")
	private AccountsDto accountsDto;
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
	public AccountsDto getAccountsDto() {
		return accountsDto;
	}


	public void setAccountsDto(AccountsDto accountsDto) {
		this.accountsDto = accountsDto;
	}


	public CustomerDto(String name, String email, String mobileNumber, AccountsDto accountsDto) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.accountsDto = accountsDto;
	}


	public CustomerDto(String name, String email, String mobileNumber) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
	
}

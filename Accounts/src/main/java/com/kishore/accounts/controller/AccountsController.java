package com.kishore.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.accounts.Constants.AccountsConstants;
import com.kishore.accounts.dto.CustomerDto;
import com.kishore.accounts.dto.ErrorResponseDto;
import com.kishore.accounts.dto.ResponseDto;
import com.kishore.accounts.service.IAccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Tag(
        name = "CRUD REST APIs for Accounts in EazyBank",
        description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {
	
	@Autowired
	private IAccountService iAccountService;
	
	 @Operation(
	            summary = "Create Account REST API",
	            description = "REST API to create new Customer &  Account inside EazyBank"
	    )
	    @ApiResponses({
	            @ApiResponse(
	                    responseCode = "201",
	                    description = "HTTP Status CREATED"
	            ),
	            @ApiResponse(
	                    responseCode = "500",
	                    description = "HTTP Status Internal Server Error",
	                    content = @Content(
	                            schema = @Schema(implementation = ErrorResponseDto.class)
	                    )
	            )
	    }
	    )
	@PostMapping("create")
	public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
		iAccountService.createAccount(customerDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
		
		
	}
	
	 
	 	@Operation(
	            summary = "Fetch Account Details REST API",
	            description = "REST API to fetch Customer &  Account details based on a mobile number"
	    )
	    @ApiResponses({
	            @ApiResponse(
	                    responseCode = "200",
	                    description = "HTTP Status OK"
	            ),
	            @ApiResponse(
	                    responseCode = "500",
	                    description = "HTTP Status Internal Server Error",
	                    content = @Content(
	                            schema = @Schema(implementation = ErrorResponseDto.class)
	                    )
	            )
	    }
	    )
	@GetMapping("fetch")
	public ResponseEntity<CustomerDto> fetchAccount(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message="mobile number must be 10 digits") String mobileNumber){
		CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(customerDto);
	}
	
	 
	 

	    @Operation(
	            summary = "Update Account Details REST API",
	            description = "REST API to update Customer &  Account details based on a account number"
	    )
	    @ApiResponses({
	            @ApiResponse(
	                    responseCode = "200",
	                    description = "HTTP Status OK"
	            ),
	            @ApiResponse(
	                    responseCode = "417",
	                    description = "Expectation Failed"
	            ),
	            @ApiResponse(
	                    responseCode = "500",
	                    description = "HTTP Status Internal Server Error",
	                    content = @Content(
	                            schema = @Schema(implementation = ErrorResponseDto.class)
	                    )
	            )
	    }
	    )
	@PutMapping("update")
	public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto){
		boolean updated = iAccountService.updateAccount(customerDto);
		
		if(updated) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		}else {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
		}	
	}
	
	    @Operation(
	            summary = "Delete Account & Customer Details REST API",
	            description = "REST API to delete Customer &  Account details based on a mobile number"
	    )
	    @ApiResponses({
	            @ApiResponse(
	                    responseCode = "200",
	                    description = "HTTP Status OK"
	            ),
	            @ApiResponse(
	                    responseCode = "417",
	                    description = "Expectation Failed"
	            ),
	            @ApiResponse(
	                    responseCode = "500",
	                    description = "HTTP Status Internal Server Error",
	                    content = @Content(
	                            schema = @Schema(implementation = ErrorResponseDto.class)
	                    )
	            )
	    }
	    )
	@DeleteMapping("delete")
	public ResponseEntity<ResponseDto> deleteAccount(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message="mobile number must be 10 digits") String mobileNumber){
		boolean deleted = iAccountService.deleteAccount(mobileNumber);
		if(deleted) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		}else {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
		}	
	}
		
		
	
	
}
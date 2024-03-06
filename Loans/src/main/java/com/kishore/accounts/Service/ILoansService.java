package com.kishore.accounts.Service;

import org.springframework.stereotype.Service;

import com.kishore.accounts.Dto.LoansDto;
import com.kishore.accounts.entity.Loans;

@Service
public interface ILoansService {

	 Loans createLoan(String mobilenumber);

	 LoansDto fetchLoan(String mobilenumber);

	 boolean updateLoan(LoansDto loansdto);

	 boolean deleteLoan(String mobilenumber);

}

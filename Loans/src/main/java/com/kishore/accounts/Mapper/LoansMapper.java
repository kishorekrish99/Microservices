package com.kishore.accounts.Mapper;

import com.kishore.accounts.Dto.LoansDto;
import com.kishore.accounts.entity.Loans;

public class LoansMapper {
	
	public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
		
		loansDto.setAmountPaid(loans.getAmountPaid());
		loansDto.setLoanNumber(loans.getLoanNumber());
		loansDto.setLoanType(loans.getLoanType());
		loansDto.setMobileNumber(loans.getMobileNumber());
		loansDto.setOutstandingAmount(loans.getOutstandingAmount());
		loansDto.setTotalLoan(loans.getTotalLoan());
		return loansDto;
	}
	
	
	public static Loans mapToLoans(Loans loans, LoansDto loansDto) {
		
		loans.setAmountPaid(loansDto.getAmountPaid());
		loans.setLoanNumber(loansDto.getLoanNumber());
		loans.setLoanType(loansDto.getLoanType());
		loans.setMobileNumber(loansDto.getMobileNumber());
		loans.setOutstandingAmount(loansDto.getOutstandingAmount());
		loans.setAmountPaid(loansDto.getAmountPaid());
		return loans;
	}
	
	
}

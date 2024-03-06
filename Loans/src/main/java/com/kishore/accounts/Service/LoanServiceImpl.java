package com.kishore.accounts.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishore.accounts.Constants.LoansConstants;
import com.kishore.accounts.Dto.LoansDto;
import com.kishore.accounts.Exceptions.LoanAlreadyExistsException;
import com.kishore.accounts.Exceptions.ResourceNotFoundException;
import com.kishore.accounts.Mapper.LoansMapper;
import com.kishore.accounts.Repository.LoansRepository;
import com.kishore.accounts.entity.Loans;

@Service
public class LoanServiceImpl implements ILoansService {

	@Autowired
	private LoansRepository loansrepository;
	
	
	 @Override
	    public Loans createLoan(String mobileNumber) {
	        Optional<Loans> optionalLoans= loansrepository.findByMobileNumber(mobileNumber);
	        if(optionalLoans.isPresent()){
	            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber "+mobileNumber);
	        }
	        Loans newloan = createNewLoan(mobileNumber);
	        newloan.setCreateAt(LocalDateTime.now());
	        newloan.setCreatedBy("Kishore");
	        loansrepository.save(newloan);
	        return newloan;
	    }


	 private Loans createNewLoan(String mobileNumber) {
	        Loans newLoan = new Loans();
	        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
	        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
	        newLoan.setMobileNumber(mobileNumber);
	        newLoan.setLoanType(LoansConstants.HOME_LOAN);
	        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
	        newLoan.setAmountPaid(0);
	        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
	       
	        return newLoan;
	    }

	
	@Override
	public LoansDto fetchLoan(String mobileNumber) {
		Loans loans = loansrepository.findByMobileNumber(mobileNumber).orElseThrow(
	           () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
				);
	    return LoansMapper.mapToLoansDto(loans, new LoansDto());
	}

	
	@Override
	public boolean updateLoan(LoansDto loansDto) {
		Loans loans = loansrepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
	                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));
		LoansMapper.mapToLoans(loans, loansDto);
		loansrepository.save(loans);
		return  true;
	}

	
	@Override
	public boolean deleteLoan(String mobileNumber) {
		Loans loans = loansrepository.findByMobileNumber(mobileNumber).orElseThrow(
	                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
	      );
		loansrepository.deleteById(loans.getLoanId());
		return true;
	    }


	
}

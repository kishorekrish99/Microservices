package com.kishore.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loans extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	private Long loanId;
	
	private String mobileNumber;
	
	private String loanNumber;
	
	private String loanType;
	
	private int totalLoan;
	
	private int amountPaid;
	
	private int outstandingAmount;
	
	public Loans() {
		
	}

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(int totalLoan) {
		this.totalLoan = totalLoan;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(int outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	@Override
	public String toString() {
		return "Loans [loanId=" + loanId + ", mobileNumber=" + mobileNumber + ", loanNumber=" + loanNumber
				+ ", loanType=" + loanType + ", totalLoan=" + totalLoan + ", amountPaid=" + amountPaid
				+ ", outstandingAmount=" + outstandingAmount + "]";
	}

	public Loans(long loanId, String mobileNumber, String loanNumber, String loanType, int totalLoan, int amountPaid,
			int outstandingAmount) {
		super();
		this.loanId = loanId;
		this.mobileNumber = mobileNumber;
		this.loanNumber = loanNumber;
		this.loanType = loanType;
		this.totalLoan = totalLoan;
		this.amountPaid = amountPaid;
		this.outstandingAmount = outstandingAmount;
	}
	

	
	
}

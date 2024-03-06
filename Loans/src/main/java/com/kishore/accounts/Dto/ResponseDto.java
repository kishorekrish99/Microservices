package com.kishore.accounts.Dto;

public class ResponseDto {

	private String StatusCode;
	
	private String StatusMessage;
	
	public ResponseDto() {
		
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public String getStatusMessage() {
		return StatusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		StatusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "ResponseDto [StatusCode=" + StatusCode + ", StatusMessage=" + StatusMessage + "]";
	}

	public ResponseDto(String statusCode, String statusMessage) {
		super();
		StatusCode = statusCode;
		StatusMessage = statusMessage;
	}
	
	
}

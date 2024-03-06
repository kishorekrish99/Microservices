package com.kishore.cards.Dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDto {
	@Schema(
            description = "Status code in the response"
    )
	private String statusCode;
	
	@Schema(
	            description = "Status message in the response"
	)
	private String statusMessage;
	
	public ResponseDto() {
		
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public ResponseDto(String statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "ResponseDto [statusCode=" + statusCode + ", statusMessage=" + statusMessage + "]";
	}
	
	
}

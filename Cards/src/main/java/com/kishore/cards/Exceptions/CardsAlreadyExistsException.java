package com.kishore.cards.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class CardsAlreadyExistsException extends RuntimeException{
	 
	
	private static final long serialVersionUID = 1L;

	public CardsAlreadyExistsException(String message){
	        super(message);
	    }
}

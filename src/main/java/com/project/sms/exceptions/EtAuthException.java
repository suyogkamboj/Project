package com.project.sms.exceptions;

//@reponseStatus(HttpStatus.UNAUTHOURIZED)
public class EtAuthException extends RuntimeException{
	
	public EtAuthException(String message) {
		super(message);
	}

}

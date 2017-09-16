package br.com.cvc.exceptions;


import org.springframework.stereotype.Component;

@Component
public class ExceptionRegraDeNegocio extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

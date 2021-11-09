package com.tecsup.petclinic.exception;

public class OwnerNotFoundException extends Exception{

	private static final long serialVersionID = 1l;
	
	//en caso no lo encuentra enviar mensaje
	public OwnerNotFoundException(String message) {
		super(message);
	}
	
}
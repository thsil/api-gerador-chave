package com.estudo.pesquisa.services.exceptions;

public class InvalidFormatDateException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public InvalidFormatDateException(Object id) {
		super("Date format invalid. Id " + id);
		
				
	}

}

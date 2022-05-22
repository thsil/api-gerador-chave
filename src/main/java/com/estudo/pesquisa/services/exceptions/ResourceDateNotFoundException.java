package com.estudo.pesquisa.services.exceptions;

public class ResourceDateNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceDateNotFoundException(Object id) {
		super("Resource date not Found " + id);
				
	}

}

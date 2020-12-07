package com.cg.onlinehomedecor.exception;

public class ProductIdNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public ProductIdNotFoundException() {
		super();
	}
	public ProductIdNotFoundException(String msg) {
		super(msg);
	}

}
package com.learning.jpa.inheritance_mapping.entities.services;

public class InvalidAccountException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidAccountException(String msg){
		super(msg);
	}
}

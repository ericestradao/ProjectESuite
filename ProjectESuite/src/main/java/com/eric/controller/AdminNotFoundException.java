package com.eric.controller;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class AdminNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2078377860330158657L;
	private String id;

	public AdminNotFoundException(String id) {
	super(String.format(" not found : '%s'",id));
	this.id=id;

	}

	public String getId() {
	return this.id;
	}

	}

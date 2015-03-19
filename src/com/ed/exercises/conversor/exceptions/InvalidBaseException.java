package com.ed.exercises.conversor.exceptions;

public class InvalidBaseException extends RuntimeException {

	public InvalidBaseException(int base) {
		_base = base;
	}

	@Override
	public String getMessage() {
		return "The base " + _base +
			"is invalid. Only positive bases up to 16 are supported.";
	}

	private static final long serialVersionUID = 1L;

	private int _base;

}
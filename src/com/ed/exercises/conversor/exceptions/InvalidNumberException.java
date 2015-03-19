package com.ed.exercises.conversor.exceptions;

public class InvalidNumberException extends RuntimeException {

	public InvalidNumberException(int base, String number) {
		_base = base;
		_number = number;
	}

	@Override
	public String getMessage() {
		return "The number " + _number +
			" does not exist in the given base (" + _base + ").";
	}

	private static final long serialVersionUID = 1L;

	private int _base;
	private String _number;

}
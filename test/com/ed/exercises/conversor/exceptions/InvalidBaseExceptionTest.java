package com.ed.exercises.conversor.exceptions;

import org.junit.Test;
public class InvalidBaseExceptionTest {

	@Test(expected = InvalidBaseException.class)
	public void testValidateInvalidNumber6() {
		try {
			throw new InvalidBaseException(-1);
		}
		catch (InvalidBaseException e) {
			System.out.println(e.getMessage());

			throw e;
		}
	}

}
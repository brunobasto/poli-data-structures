
package com.ed.exercises.conversor.exceptions;

import org.junit.Test;
public class InvalidNumberExceptionTest {

	@Test(expected = InvalidNumberException.class)
	public void testValidateInvalidNumber6() {
		try {
			throw new InvalidNumberException(-1, "XX");
		}
		catch (InvalidNumberException e) {
			System.out.println(e.getMessage());

			throw e;
		}
	}

}
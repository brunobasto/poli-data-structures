
package com.ed.exercises.conversor;

import com.ed.exercises.conversor.exceptions.InvalidBaseException;
import com.ed.exercises.conversor.exceptions.InvalidNumberException;

import org.junit.Assert;
import org.junit.Test;
public class BaseConversorTest {

	@Test
	public void testConvert() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(2);
		conversor.setToBase(10);

		Assert.assertEquals("2", conversor.convert("0010"));

		conversor.setFromBase(16);
		conversor.setToBase(10);

		Assert.assertEquals("317", conversor.convert("13D"));

		conversor.setFromBase(10);
		conversor.setToBase(16);

		Assert.assertEquals("13D", conversor.convert("317"));

		conversor.setFromBase(8);
		conversor.setToBase(16);

		Assert.assertEquals("32E", conversor.convert("1456"));
	}

	@Test(expected = InvalidBaseException.class)
	public void testValidateInvalidFromBase1() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(20);
		conversor.setToBase(5);

		conversor.convert("123");
	}

	@Test(expected = InvalidBaseException.class)
	public void testValidateInvalidFromBase2() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(-1);
		conversor.setToBase(5);

		conversor.convert("123");
	}

	@Test(expected = InvalidNumberException.class)
	public void testValidateInvalidNumber1() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(8);
		conversor.setToBase(10);

		conversor.convert("AF8");
	}

	@Test(expected = InvalidNumberException.class)
	public void testValidateInvalidNumber2() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(2);
		conversor.setToBase(10);

		conversor.convert("19");
	}

	@Test(expected = InvalidNumberException.class)
	public void testValidateInvalidNumber3() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(1);
		conversor.setToBase(10);

		conversor.convert("33");
	}

	@Test(expected = InvalidNumberException.class)
	public void testValidateInvalidNumber4() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(3);
		conversor.setToBase(10);

		conversor.convert("66");
	}

	@Test(expected = InvalidNumberException.class)
	public void testValidateInvalidNumber5() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(11);
		conversor.setToBase(10);

		conversor.convert("AD2");
	}

	@Test(expected = InvalidNumberException.class)
	public void testValidateInvalidNumber6() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(16);
		conversor.setToBase(10);

		conversor.convert("XXX");
	}

	@Test(expected = InvalidBaseException.class)
	public void testValidateInvalidToBase1() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(10);
		conversor.setToBase(19);

		conversor.convert("123");
	}

	@Test(expected = InvalidBaseException.class)
	public void testValidateInvalidToBase2() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(10);
		conversor.setToBase(-1);

		conversor.convert("123");
	}

	@Test(expected = InvalidBaseException.class)
	public void testValidateNoFromBase() {
		BaseConversor conversor = new BaseConversor();

		conversor.setToBase(5);

		conversor.convert("123");
	}

	@Test(expected = InvalidBaseException.class)
	public void testValidateNoToBase() {
		BaseConversor conversor = new BaseConversor();

		conversor.setFromBase(20);

		conversor.convert("123");
	}

	@Test
	public void testValidateValidNumber() {
		BaseConversor conversor = new BaseConversor();

		conversor.setToBase(10);

		conversor.setFromBase(8);
		conversor.convert("72");

		conversor.setFromBase(10);
		conversor.convert("157");

		conversor.setFromBase(2);
		conversor.convert("01001");

		conversor.setFromBase(12);
		conversor.convert("AB8");

		conversor.setFromBase(10);
		conversor.convert("250");
	}

}
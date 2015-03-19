
package com.ed.exercises.conversor;

import com.ed.exercises.conversor.exceptions.InvalidBaseException;
import com.ed.exercises.conversor.exceptions.InvalidNumberException;
import com.ed.structures.stack.Stack;
public class BaseConversor {

	public String convert(String number) {
		number = number.toUpperCase();

		_validateBase(getFromBase());
		_validateBase(getToBase());
		_validateNumber(number);

		double value = 0;

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);

			double power = number.length() - i - 1;

			value +=
				Character.getNumericValue(c) * Math.pow(getFromBase(), power);
		}

		Stack stack = new Stack();

		int remainder;
		double result;

		while (value > 0) {
			remainder = (int) (value % getToBase());
			result = Math.floor(value / getToBase());

			stack.push(_getDigitString(remainder));

			value = result;
		}

		String convertedNumber = "";

		while (stack.size() > 0) {
			convertedNumber += stack.pop();
		}

		System.out.println(
			"Converted (" + number + ")" + getFromBase() +
			" to (" + convertedNumber + ")" + getToBase());

		return convertedNumber;
	}

	public int getFromBase() {
		return _fromBase;
	}

	public int getToBase() {
		return _toBase;
	}

	public void setFromBase(int fromBase) {
		_fromBase = fromBase;
	}

	public void setToBase(int toBase) {
		_toBase = toBase;
	}

	private String _getDigitString(int digit) {
		String result;

		if (digit < 10) {
			result = String.valueOf(digit);
		}
		else {
			result = _SYMBOLS[digit - 10];
		}

		return result;
	}

	private void _validateBase(int base) {
		if ((base < 0) || (base > 16)) {
			throw new InvalidBaseException(base);
		}
	}

	private void _validateNumber(String number) {
		int base = getFromBase();

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);

			if (Character.getNumericValue(c) > (base - 1)) {
				throw new InvalidNumberException(base, number);
			}
		}
	}

	private static final String[] _SYMBOLS = new String[] {
		"A", "B", "C", "D", "E", "F"
	};

	private int _fromBase = -1;
	private int _toBase = -1;

}
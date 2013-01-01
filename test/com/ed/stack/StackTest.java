package com.ed.stack;

import org.junit.Assert;
import org.junit.Test;
public class StackTest {

	@Test
	public void testPop() {
		Stack stack = new Stack();

		stack.push("a");
		stack.push("b");

		Assert.assertEquals("b", stack.pop());

		Assert.assertEquals(1, stack.size());
	}

	@Test
	public void testPush() {
		Stack stack = new Stack();

		stack.push("a");
		stack.push("b");

		Assert.assertEquals(2, stack.size());
	}

}
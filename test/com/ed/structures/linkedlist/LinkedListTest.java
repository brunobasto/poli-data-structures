package com.ed.structures.linkedlist;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
public class LinkedListTest {

	@Test
	public void testAddLinear() {
		LinkedList list = new LinkedList();

		list.add("a");

		Assert.assertNotEquals(null, list.getFirst());
		Assert.assertEquals(1, list.size());

		list.add("b");
		list.add("c");

		Assert.assertEquals(3, list.size());
	}

	@Test
	public void testAddrecursive() {
		LinkedList list = new LinkedList();

		list.addRecursive("a");

		Assert.assertNotEquals(null, list.getFirst());
		Assert.assertEquals(1, list.size());

		list.addRecursive("b");
		list.addRecursive("c");

		Assert.assertEquals(3, list.size());
	}

	@Test
	public void testConstructor() {
		LinkedList list = new LinkedList();

		Assert.assertEquals(null, list.getFirst());
	}

	@Test
	public void testContains() {
		LinkedList list = new LinkedList();

		String value = "a";

		list.add(value);

		Assert.assertTrue(list.contains(value));

		Assert.assertFalse(list.contains("b"));
	}

	@Test
	public void testContainsRecursive() {
		LinkedList list = new LinkedList();

		String value = "a";

		list.add(value);

		Assert.assertTrue(list.containsRecursive(value));

		Assert.assertFalse(list.containsRecursive("b"));
	}

	@Test
	public void testGet() {
		LinkedList list = new LinkedList();

		String valueA = "a";
		String valueB = "b";

		list.add(valueA);
		list.add(valueB);

		Assert.assertEquals(valueA, list.get(0));
		Assert.assertEquals(valueB, list.get(1));
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetNotFound() {
		LinkedList list = new LinkedList();

		String valueA = "a";

		list.add(valueA);

		list.get(2);
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetWithEmptyList() {
		LinkedList list = new LinkedList();

		list.get(0);
	}

	@Test
	public void testIndexOf() {
		LinkedList list = new LinkedList();

		String valueA = "a";
		String valueB = "b";
		String valueC = "c";
		String valueD = "d";

		list.add(valueA);
		list.add(valueB);
		list.add(valueC);

		Assert.assertEquals(0, list.indexOf(valueA));
		Assert.assertEquals(1, list.indexOf(valueB));
		Assert.assertEquals(2, list.indexOf(valueC));
		Assert.assertEquals(-1, list.indexOf(valueD));
	}

	@Test
	public void testRemoveByIndex() {
		LinkedList list = new LinkedList();

		String valueA = "a";
		String valueB = "b";

		list.add(valueA);
		list.add(valueB);

		Assert.assertEquals(valueA, list.remove(0));

		Assert.assertEquals(1, list.size());
	}

	@Test
	public void testRemoveByValue() {
		LinkedList list = new LinkedList();

		String valueA = "a";
		String valueB = "b";

		list.add(valueA);
		list.add(valueB);

		Assert.assertTrue(list.remove(valueB));
		Assert.assertTrue(list.remove(valueA));
		Assert.assertFalse(list.remove(valueA));

		Assert.assertEquals(0, list.size());
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveFromEmptyList() {
		LinkedList list = new LinkedList();

		list.remove(0);
	}

	@Test
	public void testRemoveLinear() {
		LinkedList list = new LinkedList();

		list.add("a");

		list.remove(0);

		Assert.assertEquals(0, list.size());

		list.add("a");
		list.add("b");
		list.add("c");

		list.remove(1);

		Assert.assertEquals("a", list.get(0));
		Assert.assertEquals("c", list.get(1));

		Assert.assertEquals(2, list.size());
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveOutOfBounds() {
		LinkedList list = new LinkedList();

		list.add("a");

		list.remove(1);
	}

	@Test
	public void testRemoveRecursive() {
		LinkedList list = new LinkedList();

		list.add("a");

		list.removeRecursive(0);

		Assert.assertEquals(0, list.size());

		list.add("a");
		list.add("b");
		list.add("c");

		list.removeRecursive(1);

		Assert.assertEquals("a", list.get(0));
		Assert.assertEquals("c", list.get(1));

		Assert.assertEquals(2, list.size());
	}

}
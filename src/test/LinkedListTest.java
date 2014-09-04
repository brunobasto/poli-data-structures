package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ed.linkedlist.LinkedList;

public class LinkedListTest {

	@Test
	public void testConstructor() {
		LinkedList list = new LinkedList();

		assertEquals(null, list.getFirst());
	}

	@Test
	public void testAddLinear() {
		LinkedList list = new LinkedList();

		list.add("a");

		assertNotEquals(null, list.getFirst());
		assertEquals(1, list.size());

		list.add("b");
		list.add("c");

		assertEquals(3, list.size());
	}

	@Test
	public void testAddrecursive() {
		LinkedList list = new LinkedList();

		list.add("a", true);

		assertNotEquals(null, list.getFirst());
		assertEquals(1, list.size());

		list.add("b", true);
		list.add("c", true);

		assertEquals(3, list.size());
	}

	@Test
	public void testRemoveLinear() {
		LinkedList list = new LinkedList();

		list.add("a");

		list.remove(0);

		assertEquals(0, list.size());

		list.add("a");
		list.add("b");
		list.add("c");

		list.remove(1);

		assertEquals(2, list.size());
		
		
	}
	
	@Test
	public void testRemoveRecursive() {
		LinkedList list = new LinkedList();

		list.add("a");

		list.remove(0, true);

		assertEquals(0, list.size());
	}

}

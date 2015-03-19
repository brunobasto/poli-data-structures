package com.ed.structures.queue;

import org.junit.Assert;
import org.junit.Test;
public class QueueTest {

	@Test
	public void testDequeue() {
		Queue queue = new Queue();

		queue.enqueue("a");
		queue.enqueue("b");

		Assert.assertEquals("a", queue.dequeue());

		Assert.assertEquals(1, queue.size());
	}

	@Test
	public void testEnqueue() {
		Queue queue = new Queue();

		queue.enqueue("a");
		queue.enqueue("b");

		Assert.assertEquals(2, queue.size());
	}

}
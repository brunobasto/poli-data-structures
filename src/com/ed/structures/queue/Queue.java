package com.ed.structures.queue;

import com.ed.structures.linkedlist.LinkedList;
public class Queue {

	public Queue() {
		list = new LinkedList();
	}

	public Object dequeue() {
		return list.remove(0);
	}

	public void enqueue(Object value) {
		list.add(value);
	}

	public int size() {
		return list.size();
	}

	private LinkedList list;

}
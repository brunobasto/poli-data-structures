package com.ed.structures.stack;

import com.ed.structures.linkedlist.LinkedList;
public class Stack {

	public Stack() {
		list = new LinkedList();
	}

	public Object pop() {
		return list.remove(size() - 1);
	}

	public void push(Object value) {
		list.add(value);
	}

	public int size() {
		return list.size();
	}

	private LinkedList list;

}
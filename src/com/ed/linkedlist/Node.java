package com.ed.linkedlist;

public class Node {

	private Node next;
	private Node prev;

	private Object value;

	public Node(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getValue() {
		return value;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
}

package com.ed.linkedlist;

public class Node {

	public void setPrev(Node prev) {
		this.prev = prev;
	} private Node prev;

	private Object value;

	public Node(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

	public Object getValue() {
		return value;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	private Node next;

}
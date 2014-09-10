package com.ed.linkedlist;

public class Node {

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

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	private Node next;
	private Node prev;
	private Object value;

}
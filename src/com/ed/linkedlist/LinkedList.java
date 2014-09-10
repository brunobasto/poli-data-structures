package com.ed.linkedlist;

import java.util.NoSuchElementException;
public class LinkedList {

	public LinkedList() {
		this.first = null;
	}

	public void add(Object value) {
		addLinear(value);
	}

	public boolean addRecursive(Object value) {
		return addRecursive(value, getFirst());
	}

	public boolean contains(Object value) {
		if (size() == 0) {
			return false;
		}

		Node currentNode = getFirst();

		do {
			if (currentNode.getValue().equals(value)) {
				return true;
			}

			currentNode = currentNode.getNext();
		}
		while (currentNode != null);

		return false;
	}

	public boolean containsRecursive(Object value) {
		return containsRecursive(value, getFirst());
	}

	public Object get(int index) {
		if (size() == 0) {
			throw new NoSuchElementException();
		}

		Node currentNode = getFirst();

		int count = 0;

		do {
			if (count == index) {
				return currentNode.getValue();
			}

			currentNode = currentNode.getNext();

			count++;
		}
		while (currentNode != null);

		throw new NoSuchElementException();
	}

	public Node getFirst() {
		return first;
	}

	public int indexOf(Object value) {
		if (!contains(value)) {
			return -1;
		}

		Node currentNode = getFirst();

		int index = 0;

		do {
			if ((currentNode != null) && currentNode.getValue().equals(value)) {
				return index;
			}

			currentNode = currentNode.getNext();

			index++;
		}
		while (currentNode != null);

		return -1;
	}

	public Object remove(int index) {
		if (size() == 0) {
			throw new NoSuchElementException();
		}

		Node currentNode = getFirst();

		int currentIndex = 0;

		do {
			if (currentIndex == index) {
				Node nextNode = currentNode.getNext();
				Node prevNode = currentNode.getPrev();

				if (nextNode != null) {
					nextNode.setPrev(prevNode);
				}

				if (prevNode != null) {
					prevNode.setNext(nextNode);
				}

				Object value = currentNode.getValue();

				currentNode = null;

				if (currentIndex == 0) {
					setFirst(currentNode);
				}

				return value;
			}

			currentNode = currentNode.getNext();

			currentIndex++;
		}
		while (currentNode != null);

		throw new NoSuchElementException();
	}

	public boolean remove(Object value) {
		if (!contains(value)) {
			return false;
		}

		Node currentNode = getFirst();

		int currentIndex = 0;

		do {
			if (get(currentIndex).equals(value)) {
				remove(currentIndex);

				return true;
			}

			currentNode = currentNode.getNext();

			currentIndex++;
		}
		while (currentNode != null);

		return false;
	}

	public Object removeRecursive(int index) {
		return removeRecursive(index, getFirst(), 0);
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int size() {
		Node currentNode = getFirst();

		int size = 0;

		while (currentNode != null) {
			currentNode = currentNode.getNext();

			size++;
		}

		return size;
	}

	private void addLinear(Object value) {
		Node currentNode = getFirst();

		Node newNode = new Node(value);

		if (currentNode == null) {
			setFirst(newNode);
		}
		else {
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}

			currentNode.setNext(newNode);
			newNode.setPrev(currentNode);
		}
	}

	private boolean addRecursive(Object value, Node currentNode) {
		boolean added = false;

		Node newNode = new Node(value);

		if (currentNode == null) {
			setFirst(newNode);

			added = true;
		}
		else {
			if (currentNode.getNext() == null) {
				currentNode.setNext(newNode);
				newNode.setPrev(currentNode);

				added = true;
			}
			else {
				added = addRecursive(value, currentNode.getNext());
			}
		}

		return added;
	}

	private boolean containsRecursive(Object value, Node currentNode) {
		if (currentNode == null) {
			return false;
		}

		if (value.equals(currentNode.getValue())) {
			return true;
		}
		else {
			return containsRecursive(value, currentNode.getNext());
		}
	}

	private Object removeRecursive(
		int index, Node currentNode, int currentIndex) {

		Object removedValue = null;

		if (index == currentIndex) {
			if (index == 0) {
				setFirst(currentNode.getNext());
			}
			else {
				Node prev = currentNode.getPrev();
				Node next = currentNode.getNext();

				prev.setNext(next);
				next.setPrev(prev);
			}

			removedValue = currentNode.getValue();
		}
		else {
			currentNode = currentNode.getNext();

			removeRecursive(index, currentNode, ++currentIndex);
		}

		return removedValue;
	}

	private Node first;

}
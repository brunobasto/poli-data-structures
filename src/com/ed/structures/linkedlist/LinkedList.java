package com.ed.structures.linkedlist;

import java.util.NoSuchElementException;
public class LinkedList {

	public LinkedList() {
		this.first = null;
	}

	public boolean add(Object value) {
		return addLinear(value);
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
		int index = -1;

		if (!contains(value)) {
			return index;
		}

		Node currentNode = getFirst();

		index = 0;

		do {
			if ((currentNode != null) && currentNode.getValue().equals(value)) {
				break;
			}

			currentNode = currentNode.getNext();

			index++;
		}
		while (currentNode != null);

		return index;
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

				if (currentIndex == 0) {
					setFirst(nextNode);
				}

				currentNode = null;

				return value;
			}

			currentNode = currentNode.getNext();

			currentIndex++;
		}
		while (currentNode != null);

		throw new NoSuchElementException();
	}

	public boolean remove(Object value) {
		boolean removed = false;

		if (!contains(value)) {
			return removed;
		}

		Node currentNode = getFirst();

		int currentIndex = 0;

		do {
			if (get(currentIndex).equals(value)) {
				remove(currentIndex);

				removed = true;

				break;
			}

			currentNode = currentNode.getNext();

			currentIndex++;
		}
		while (currentNode != null);

		return removed;
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

	private boolean addLinear(Object value) {
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

		return true;
	}

	private boolean addRecursive(Object value, Node currentNode) {
		Node newNode = new Node(value);

		if (currentNode == null) {
			setFirst(newNode);
		}
		else {
			if (currentNode.getNext() == null) {
				currentNode.setNext(newNode);
				newNode.setPrev(currentNode);
			}
			else {
				return addRecursive(value, currentNode.getNext());
			}
		}

		return false;
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
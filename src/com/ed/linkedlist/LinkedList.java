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
		Node currentNode = getFirst();

		if (currentNode.getValue().equals(value)) {
			return true;
		}
		else {
			while (currentNode != null) {
				if (currentNode.getValue().equals(value)) {
					return true;
				}

				currentNode = currentNode.getNext();
			}
		}

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
		Node currentNode = getFirst();

		if (currentNode.getValue().equals(value)) {
			return 0;
		}
		else {
			int index = 0;

			while (currentNode != null) {
				currentNode = currentNode.getNext();

				index++;

				if ((currentNode != null) &&
					currentNode.getValue().equals(value)) {

					return index;
				}
			}
		}

		return -1;
	}

	public Object remove(int index) {
		Object removed = null;

		Node currentNode = getFirst();

		if ((index == 0) && (currentNode != null)) {
			removed = getFirst();

			setFirst(currentNode.getNext());
		}
		else {
			int count = 0;

			while (currentNode != null) {
				currentNode = currentNode.getNext();

				count++;

				if (count == index) {
					Node nextNode = currentNode.getNext();
					Node prevNode = currentNode.getPrev();

					nextNode.setPrev(prevNode);
					prevNode.setNext(nextNode);
				}
			}
		}

		return removed;
	}

	public boolean remove(Object value) {
		int index = 0;

		Node currentNode = getFirst();

		if (currentNode.getValue().equals(value)) {
			removeRecursive(index);

			return true;
		}
		else {
			while (currentNode != null) {
				currentNode = currentNode.getNext();

				index++;

				if (currentNode.getValue().equals(value)) {
					removeRecursive(index);

					return true;
				}
			}
		}

		return false;
	}

	public Object removeRecursive(int index) {
		return removeRecursive(index, getFirst(), 0);
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int size() {
		int count = 0;

		Node currentNode = getFirst();

		while (currentNode != null) {
			currentNode = currentNode.getNext();

			count++;
		}

		return count;
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
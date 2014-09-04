package com.ed.linkedlist;

public class LinkedList {

	private Node first;

	public LinkedList() {
		this.first = null;
	}

	public void add(Object value) {
		addLinear(value);
	}

	public void add(Object value, boolean recursive) {
		if (recursive) {
			addRecursive(value, getFirst());
		} else {
			addLinear(value);
		}
	}

	public Node getFirst() {
		return first;
	}

	public void remove(int index) {
		removeLinear(index);
	}

	public void remove(int index, boolean recursive) {
		if (recursive) {
			removeRecursive(index, getFirst());
		} else {
			removeLinear(index);
		}
	}

	private void removeLinear(int index) {
		Node currentNode = getFirst();

		if (index == 0 && currentNode != null) {
			setFirst(currentNode.getNext());
		} else if (currentNode == null) {
			return;
		} else {
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
	}

	private void removeRecursive(int index, Node currentNode) {
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
		} else {
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}

			currentNode.setNext(newNode);
			newNode.setPrev(currentNode);
		}
	}

	private void addRecursive(Object value, Node currentNode) {
		Node newNode = new Node(value);

		if (currentNode == null) {
			setFirst(newNode);
		} else {
			if (currentNode.getNext() == null) {
				currentNode.setNext(newNode);
				newNode.setPrev(currentNode);
			} else {
				addRecursive(value, currentNode.getNext());
			}
		}
	}

}

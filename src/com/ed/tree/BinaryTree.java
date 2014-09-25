package com.ed.tree;

import com.ed.queue.Queue;
import com.ed.stack.Stack;
public class BinaryTree {

	public boolean breadthSearch(int x) {
		Queue queue = new Queue();

		queue.enqueue(root);

		while (queue.size() > 0) {
			BinaryNode next = (BinaryNode)queue.dequeue();

			if (next.getInfo() == x) {
				return true;
			}
			else {
				if (next.getLeft() != null) {
					queue.enqueue(next.getLeft());
				}

				if (next.getRight() != null) {
					queue.enqueue(next.getRight());
				}
			}
		}

		return false;
	}

	public boolean depthSearch(int x) {
		Stack stack = new Stack();

		stack.push(root);

		while (stack.size() > 0) {
			BinaryNode next = (BinaryNode)stack.pop();

			if (next.getInfo() == x) {
				return true;
			}
			else {
				if (next.getLeft() != null) {
					stack.push(next.getLeft());
				}

				if (next.getRight() != null) {
					stack.push(next.getRight());
				}
			}
		}

		return false;
	}

	public void insert(int x) {
		BinaryNode node = new BinaryNode(x);

		if (root == null) {
			root = node;
		}
		else {
			BinaryNode aux = root;

			while (aux != null) {
				if (aux.getInfo() == x) {
					break;
				}
				else if (x < aux.getInfo()) {
					if (aux.getLeft() == null) {
						aux.setLeft(node);

						break;
					}
					else {
						aux = aux.getLeft();
					}
				}
				else {
					if (aux.getRight() == null) {
						aux.setRight(node);

						break;
					}
					else {
						aux = aux.getRight();
					}
				}
			}
		}
	}

	public void printNodes() {
		printNodes(root);
	}

	private void printNodes(BinaryNode node) {
		if (node != null) {
			printNodes(node.getLeft());

			System.out.println(node.getInfo());

			printNodes(node.getRight());
		}
	}

	private BinaryNode root;

}
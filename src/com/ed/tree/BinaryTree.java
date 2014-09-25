package com.ed.tree;

public class BinaryTree {

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
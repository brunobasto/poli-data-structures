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
				if (aux.info == x) {
					break;
				}
				else if (x < aux.info) {
					if (aux.left == null) {
						aux.left = node;

						break;
					}
					else {
						aux = aux.left;
					}
				}
				else {
					if (aux.right == null) {
						aux.right = node;

						break;
					}
					else {
						aux = aux.right;
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
			printNodes(node.left);

			System.out.println(node.info);

			printNodes(node.right);
		}
	}

	private BinaryNode root;

}
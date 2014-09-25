package com.ed.tree;

public class BinaryNode {

	public BinaryNode(int x) {
		info = x;
	}

	public int getInfo() {
		return info;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	private int info;
	private BinaryNode left;
	private BinaryNode right;

}
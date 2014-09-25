package com.ed.tree;

import org.junit.Assert;
import org.junit.Test;
public class BinaryTreeTest {

	@Test
	public void testBreadthSearch() {
		BinaryTree tree = getBinaryTree(50);

		tree.printNodes();

		Assert.assertTrue(tree.breadthSearch(50));
	}

	private BinaryTree getBinaryTree(int mustHave) {
		BinaryTree tree = new BinaryTree();

		tree.insert(18);
		tree.insert(74);
		tree.insert(31);
		tree.insert(73);
		tree.insert(23);
		tree.insert(35);
		tree.insert(66);

		tree.insert(mustHave);

		return tree;
	}

}
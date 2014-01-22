package exercise.tree;

import datastructure.tree.BTreeNode;
import datastructure.tree.IntBinarySearchTree;

public class BSTMain {
	public static void main(String[] args) {
		IntBinarySearchTree bst = new IntBinarySearchTree(new BTreeNode<Integer>(12));
		bst.insertNode(8);
		bst.insertNode(17);

		bst.insertNode(13);
		bst.insertNode(9);
		bst.insertNode(4);
		bst.insertNode(21);
		
		bst.insertNode(2);
		bst.insertNode(7);
		bst.insertNode(10);

		bst.removeNode(12);
		bst.postorderTraverse();
	}
}

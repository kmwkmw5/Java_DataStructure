package exercise.tree;

import datastructure.tree.IntAVLTree;
import datastructure.tree.BTreeNode;

public class AVLTreeMain {
	public static void main(String[] args) {
		BTreeNode<Integer> root = new BTreeNode<Integer>(1);
		IntAVLTree avl = new IntAVLTree(root);
		avl.insertNode(2);
		avl.insertNode(3);
		avl.insertNode(4);
		avl.insertNode(5);
		avl.insertNode(6);
		avl.insertNode(7);
		avl.insertNode(8);
		avl.insertNode(9);
		
		root = avl.greatRootNode;
		System.out.println(root.getLeft().getLeft().getLeft().getLeft().getData());
	}
}
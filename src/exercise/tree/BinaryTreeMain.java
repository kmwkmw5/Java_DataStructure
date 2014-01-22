package exercise.tree;
import datastructure.tree.*;

public class BinaryTreeMain {
	public static void main(String[] args) {
		BTreeNode<Integer> bt1 = new BTreeNode<Integer>(1);
		BTreeNode<Integer> bt2 = new BTreeNode<Integer>(2);
		BTreeNode<Integer> bt3 = new BTreeNode<Integer>(3);
		BTreeNode<Integer> bt4 = new BTreeNode<Integer>(4);
		
		bt1.setLeft(bt2);
		bt1.setRight(bt3);
		bt2.setLeft(bt4);

		bt1.inorderTraverse();
		System.out.println();
		bt1.preorderTraverse();
		System.out.println();
		bt1.postorderTraverse();
	}
}

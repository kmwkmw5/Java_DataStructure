package datastructure.tree;

public class BTreeNode<T> {
	private T data;
	private BTreeNode<T> left;
	private BTreeNode<T> right;
	
	// 생성자
	public BTreeNode() {
		this.data = null;
		this.left = null;
		this.right = null;
	}
	public BTreeNode(T data, BTreeNode<T> left, BTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public BTreeNode(T data, BTreeNode<T> left) {
		this.data = data;
		this.left = left;
		this.right = null;
	}
	public BTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public BTreeNode(BTreeNode<T> left, BTreeNode<T> right) {
		this.data = null;
		this.left = left;
		this.right = right;
	}
	public BTreeNode(BTreeNode<T> left) {
		this.data = null;
		this.left = left;
		this.right = null;
	}
	
	// 게터 세터 클론
	public T getData() {
		return data;
	}
	public BTreeNode<T> getLeft() {
		return left;
	}
	public BTreeNode<T> getRight() {
		return right;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setLeft(BTreeNode<T> left) {
		this.left = left;
	}
	public void setRight(BTreeNode<T> right) {
		this.right = right;
	}
	
	// 중위 탐색
	public void inorderTraverse() {
		if(this.left != null)
			this.left.inorderTraverse();
		System.out.println(this.data);
		if(this.right != null)
			this.right.inorderTraverse();
	}
	// 전위 탐색
	public void preorderTraverse() {
		System.out.println(this.data);
		if(this.left != null)
			this.left.preorderTraverse();
		if(this.right != null)
			this.right.preorderTraverse();
	}
	// 후위 탐색
	public void postorderTraverse() {
		if(this.left != null)
			this.left.postorderTraverse();
		if(this.right != null)
			this.right.postorderTraverse();
		System.out.println(this.data);
	}
}
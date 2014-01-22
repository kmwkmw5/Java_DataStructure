package datastructure.tree;

public class IntBinarySearchTree {
	public BTreeNode<Integer> greatRootNode;
	
	public IntBinarySearchTree(BTreeNode<Integer> rootNode) {
		this.greatRootNode = rootNode;
	}
	
	public Integer getNodeData(BTreeNode<Integer> node) {
		return node.getData();
	}
	
	public void insertNode(Integer data) {
		insertNode(data, greatRootNode);
	}
	private void insertNode(Integer data, BTreeNode<Integer> rootNode) {
		// data가 더 작으면
		if(rootNode.getData() > data) {
			// 왼쪽이 비어있지 않으면 왼쪽 서브트리에서 다시 삽입
			if(rootNode.getLeft() != null) {
				insertNode(data, rootNode.getLeft());
			}
			// 왼쪽이 비어있다면 새 노드 삽입
			else {
				BTreeNode<Integer> newNode = new BTreeNode<Integer>(data);
				rootNode.setLeft(newNode);
			}
		}
		// data가 더 크면
		else if(rootNode.getData() < data) {
			// 오른쪽이 비어있지 않으면 오른쪽 서브트리에서 다시 삽입
			if(rootNode.getRight() != null) {
				insertNode(data, rootNode.getRight());
			}
			// 오른쪽이 비어있다면 새 노드 삽입
			else {
				BTreeNode<Integer> newNode = new BTreeNode<Integer>(data);
				rootNode.setRight(newNode);
			}
		}
	}
	
	public BTreeNode<Integer> searchNode(Integer target) {
		return searchNode(target, greatRootNode);
	}
	private BTreeNode<Integer> searchNode(Integer target, BTreeNode<Integer> rootNode) {
		if(rootNode.getData() == target)
			return rootNode;
		else if(rootNode.getData() > target) {
			return searchNode(target, rootNode.getLeft());
		}
		else {
			return searchNode(target, rootNode.getRight());
		}
	}
	
	public BTreeNode<Integer> searchParentNode(Integer target) {
		return searchParentNode(target, greatRootNode);
	}
	private BTreeNode<Integer> searchParentNode(Integer target, BTreeNode<Integer> rootNode) {
		if(rootNode.getData() == target) {
			return null;
		}
		else if(isGetChild(target, rootNode))
			return rootNode;
		else if(rootNode.getData() > target)
			return searchParentNode(target, rootNode.getLeft());
		else
			return searchParentNode(target, rootNode.getRight());
	}
	private boolean isGetChild(Integer childData, BTreeNode<Integer> btNode) {
		if(btNode == null)
			return false;
		else if(btNode.getLeft() != null && btNode.getLeft().getData() == childData)
			return true;
		else if(btNode.getRight() != null && btNode.getRight().getData() == childData)
			return true;
		return false;
	}
	
	public BTreeNode<Integer> searchMaxDataNode() {
		return searchMaxDataNode(greatRootNode);
	}
	private BTreeNode<Integer> searchMaxDataNode(BTreeNode<Integer> rootNode) {
		if(rootNode.getRight() != null)
			return searchMaxDataNode(rootNode.getRight());
		else
			return rootNode;
	}
	public BTreeNode<Integer> searchMinDataNode() {
		return searchMinDataNode(greatRootNode);
	}
	private BTreeNode<Integer> searchMinDataNode(BTreeNode<Integer> rootNode) {
		if(rootNode.getLeft() != null)
			return searchMinDataNode(rootNode.getLeft());
		else
			return rootNode;
	}
	
	public BTreeNode<Integer> removeNode(Integer target) {
		BTreeNode<Integer> virtualNode = new BTreeNode<Integer>(this.greatRootNode);
		BTreeNode<Integer> delParentNode;
		BTreeNode<Integer> delNode = searchNode(target);
		if(delNode == this.greatRootNode)
			delParentNode = virtualNode;
		else
			delParentNode = searchParentNode(target);
		// 삭제할 노드가 없는 경우
		if(delNode == null)
			return null;
		// 삭제할 노드가 단말 노드인 경우
		else if(delNode.getLeft() == null && delNode.getRight() == null) {
			if(delParentNode.getLeft() == delNode)
				delParentNode.setLeft(null);
			else
				delParentNode.setRight(null);
		}
		// 삭제할 노드가 왼쪽 자식만을 갖는 경우
		else if(delNode.getLeft() != null && delNode.getRight() == null) {
			if(delParentNode.getLeft() == delNode)
				delParentNode.setLeft(delNode.getLeft());
			else
				delParentNode.setRight(delNode.getLeft());
		}
		// 삭제할 노드가 오른쪽 자식만을 갖는 경우
		else if(delNode.getLeft() == null && delNode.getRight() != null) {
			if(delParentNode.getLeft() == delNode)
				delParentNode.setLeft(delNode.getRight());
			else
				delParentNode.setRight(delNode.getRight());
		}
		// 삭제할 노드가 양 쪽 자식을 모두 갖는 경우
		else {
			BTreeNode<Integer> replaceNode = searchMinDataNode(delNode.getRight());
			replaceNode = removeNode(replaceNode.getData());
			replaceNode.setLeft(delNode.getLeft());
			replaceNode.setRight(delNode.getRight());
			if(delParentNode.getLeft() == delNode)
				delParentNode.setLeft(replaceNode);
			else
				delParentNode.setRight(replaceNode);
		}
		
		// 루트 노드가 바뀌었을 경우 재설정
		if(virtualNode.getLeft() != this.greatRootNode)
			this.greatRootNode = virtualNode.getLeft();
		return delNode;
	}
	
	public void inorderTraverse() {
		this.greatRootNode.inorderTraverse();
	}
	public void preorderTraverse() {
		this.greatRootNode.preorderTraverse();
	}
	public void postorderTraverse() {
		this.greatRootNode.postorderTraverse();
	}
}

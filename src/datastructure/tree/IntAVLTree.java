package datastructure.tree;

public class IntAVLTree extends IntBinarySearchTree {
	public IntAVLTree(BTreeNode<Integer> rootNode) {
		super(rootNode);
	}
	
	public void insertNode(Integer data) {
		super.insertNode(data);
		this.greatRootNode = rebalance(this.greatRootNode);
	}
	
	public BTreeNode<Integer> removeNode(Integer target) {
		BTreeNode<Integer> delNode = super.removeNode(target);
		this.greatRootNode = rebalance(this.greatRootNode);
		return delNode;
	}
	
	private int getHeight(BTreeNode<Integer> rootNode) {
		if(rootNode == null)
			return 0;
		
		int leftH = getHeight(rootNode.getLeft());
		int rightH = getHeight(rootNode.getRight());
		
		if(leftH > rightH)
			return leftH + 1;
		else
			return rightH + 1;
	}
	private int getHeightDiff(BTreeNode<Integer> rootNode) {
		if(rootNode == null)
			return 0;
		
		int leftH = getHeight(rootNode.getLeft());
		int rightH = getHeight(rootNode.getRight());
		
		return leftH - rightH;
	}
	
	private BTreeNode<Integer> rotateLL(BTreeNode<Integer> rootNode) {
		BTreeNode<Integer> pNode = rootNode;
		BTreeNode<Integer> cNode = rootNode.getLeft();
		
		pNode.setLeft(cNode.getRight());
		cNode.setRight(pNode);
		
		return cNode;
	}
	private BTreeNode<Integer> rotateRR(BTreeNode<Integer> rootNode) {
		BTreeNode<Integer> pNode = rootNode;
		BTreeNode<Integer> cNode = rootNode.getRight();
		
		pNode.setRight(cNode.getLeft());
		cNode.setLeft(pNode);
		
		return cNode;
	}
	private BTreeNode<Integer> rotateLR(BTreeNode<Integer> rootNode) {
		BTreeNode<Integer> pNode = rootNode;
		BTreeNode<Integer> cNode = rootNode.getLeft();
		
		pNode.setLeft(rotateRR(cNode));
		return rotateLL(pNode);
	}
	private BTreeNode<Integer> rotateRL(BTreeNode<Integer> rootNode) {
		BTreeNode<Integer> pNode = rootNode;
		BTreeNode<Integer> cNode = rootNode.getRight();
		
		pNode.setRight(rotateLL(cNode));
		return rotateRR(pNode);
	}

	private BTreeNode<Integer> rebalance(BTreeNode<Integer> rootNode) {
		int hDiff = getHeightDiff(rootNode);
		
		// 균형 인수가 +2 이상이면 LL상태 또는 LR상태
		if(hDiff > 1) {
			// 왼쪽 자식의 균형 인수가 양수이면 LL상태
			if(getHeightDiff(rootNode.getLeft()) > 0)
				rootNode = rotateLL(rootNode);
			else
				rootNode = rotateLR(rootNode);
		}
		// 균형 인수가 -2 이하이면 RR상태 또는 RL상태
		else if(hDiff < -1) {
			// 오른쪽 자식의 균형 인수가 음수이면 RR상태
			if(getHeightDiff(rootNode.getRight()) < 0)
				rootNode = rotateRR(rootNode);
			else
				rootNode = rotateRL(rootNode);
		}
		
		return rootNode;
	}
}

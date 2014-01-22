package datastructure.tree;

public class Heap<T> {
	public static final int HEAP_LEN = 100;
	private final int NON_EXISTENT = -1;
	private HeapElement<T>[] heapArr;
	private int numOfData; // element 개수이자 마지막 index를 의미함
	
	@SuppressWarnings("unchecked")
	public Heap() {
		//heapArr = (HeapElement<T>[])new Object[HEAP_LEN];
		heapArr = new HeapElement[HEAP_LEN];
		numOfData = 0;
	}
	
	private int getParentIDX(int idx) {
		int parentIDX = idx/2;
		if(parentIDX < 1)
			return NON_EXISTENT;
		else
			return parentIDX;
	}
	private int getLChildIDX(int idx) {
		int lChildIDX = idx*2;
		if(lChildIDX > numOfData)
			return NON_EXISTENT;
		else
			return lChildIDX;
	}
	private int getRChildIDX(int idx) {
		int rChildIDX = idx*2 + 1;
		if(rChildIDX > numOfData)
			return NON_EXISTENT;
		else
			return rChildIDX;
	}
	private int getHighPriorityChildIDX(int idx) {
		if(isEmpty()) {
			System.out.println("getHighPriorityChildIDX() Error!!!");
			System.out.println("Heap is Empty!!!");
			return 0; // Error
		}
		
		int lChildIDX = getLChildIDX(idx);
		int rChildIDX = getRChildIDX(idx);
		
		if(lChildIDX == NON_EXISTENT)
			return NON_EXISTENT;
		else if(rChildIDX == NON_EXISTENT)
			return lChildIDX;
		
		HeapElement<T> leftChild = heapArr[lChildIDX];
		HeapElement<T> rightChild = heapArr[rChildIDX];
		
		if(leftChild.getPriority() < rightChild.getPriority())
			return lChildIDX;
		else
			return rChildIDX;
	}
	
	public boolean isEmpty() {
		if(numOfData == 0)
			return true;
		else
			return false;
	}
	
	public void insert(T data, int priority) {
		int idx = numOfData + 1;
		if(idx == HEAP_LEN) {
			System.out.println("Heap is Full!!!");
			return;
		}

		while(idx != 1) {
			if(priority < heapArr[getParentIDX(idx)].getPriority()) {
				heapArr[idx] = heapArr[getParentIDX(idx)];
				idx = getParentIDX(idx);
			}
			else
				break;
		}
		heapArr[idx] = new HeapElement<T>(data, priority);

		numOfData++;
	}
	
	public T delete() {
		if(isEmpty()) {
			System.out.println("Heap is Empty!!!");
			System.out.println("delete() will return null!!!");
			return null;
		}

		T delData = heapArr[1].getData();
		int idx = 1;
		int childIDX;
		int priority = heapArr[numOfData].getPriority();
		
		while((childIDX = getHighPriorityChildIDX(idx)) != NON_EXISTENT) {
			if(priority > heapArr[childIDX].getPriority()) {
				heapArr[idx] = heapArr[childIDX];
				idx = childIDX;
			}
			else
				break;
		}
		
		heapArr[idx] = heapArr[numOfData];
		numOfData--;
		return delData;
	}
}

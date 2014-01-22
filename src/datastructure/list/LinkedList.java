package datastructure.list;
public class LinkedList<T> implements List<T> {
	protected Node<T> head;
	protected Node<T> cur;
	protected Node<T> before;
	protected int numOfData;
	
	public LinkedList() {
		head = new Node<T>();
		cur = head;
		before = null;
		numOfData = 0;
	}


	private void isEmptyException() {
		try {
			if(isEmpty())
				throw new Exception("List is null");
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	private void isLastRefException() {
		try {
			if(cur.next == null)
				throw new Exception("List isn't have next data");
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void insert(T data) {
		Node<T> pred = head;
		while(pred.next!=null && compData(data, pred.next.data)) {
			pred = pred.next;
		} // compData를 구현하지 않았다면 계속해서 head에 추가
		Node<T> newNode = new Node<T>(data, pred.next);
		pred.next = newNode;
		numOfData++;
	}
	public T remove() {
		isEmptyException();
		
		T temp = cur.data;
		before.next = cur.next;
		cur = before;
		numOfData--;
		return temp;
	}
	
	
	public T first() {
		isEmptyException();
		
		before = head;
		cur = before.next;
		return cur.data;
	}
	public T next() {
		isEmptyException();
		isLastRefException();
		
		before = cur;
		cur = before.next;
		return cur.data;
	}
	
	
	public void setFirst() {
		cur = head;
		before = null;
	}
	public boolean isNext() {
		if(cur.next == null)
			return false;
		else
			return true;
	}
	public boolean isEmpty() {
		if(numOfData <= 0)
			return true;
		else
			return false;
	}
	public int count() {
		return numOfData;
	}

	
	public void printAllData() {
		printAllData(" ");
	}
	public void printAllData(char delimiter) {
		Character c = delimiter;
		printAllData(c.toString());
	}
	public void printAllData(String delimiter) {
		System.out.print(first());
		while(isNext()) {
			System.out.print(delimiter + next());
		}
		System.out.println();
	}
	
	
	/*	상속전용 메소드. 데이터를 정렬하려면 오버라이딩해서 구현한다.
		오버로딩하면 작동하지 않는다.
		d1이 앞서면 false, d2가 앞서면 true */
	protected boolean compData(T d1, T d2) {
		return false;
	}
}
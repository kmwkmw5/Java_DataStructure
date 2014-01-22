package datastructure.list;
public class ArrayList<T> implements List<T> {
	private T[] arr;
	private int numOfData;
	private int curPosition;
	private static final int LIST_LEN = 100;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		arr = (T[]) new Object[LIST_LEN];
		numOfData = 0;
		curPosition = -1;
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
			if(curPosition >= numOfData-1)
				throw new Exception("List isn't have next data");
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	public void insert(T data) {
		if(numOfData >= LIST_LEN) {
			System.out.println("Warning: List Full!!");
			return;
		}
		curPosition++;
		numOfData++;
		arr[curPosition] = data;
	}
	public T remove() {
		isEmptyException();
		
		T temp = arr[curPosition];
		for(int i=curPosition+1; i<numOfData; i++) {
			arr[i-1] = arr[i];
		}
		numOfData--;
		curPosition--;
		return temp;
	}
	
	
	public T first() {
		isEmptyException();
		
		curPosition=0;
		return arr[curPosition];
	}
	public T next() {
		isEmptyException();
		isLastRefException();
		
		curPosition++;
		return arr[curPosition];
	}
	
	public void setFirst() {
		curPosition = -1;
	}
	public boolean isNext() {
		if(curPosition >= numOfData - 1)
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
}

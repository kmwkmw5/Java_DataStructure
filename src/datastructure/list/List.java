package datastructure.list;

public interface List<T> {
	public void insert(T data);
	public T remove();
	
	public T first();
	public T next();
	
	public void setFirst();
	public boolean isNext();
	public boolean isEmpty();
	public int count();
	
	public void printAllData();
	public void printAllData(char delimiter);
	public void printAllData(String delimiter);
}

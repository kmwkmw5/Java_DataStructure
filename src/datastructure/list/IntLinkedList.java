package datastructure.list;
public class IntLinkedList extends LinkedList<Integer> {	
	protected boolean compData(Integer d1, Integer d2) {
		if(d1 < d2)
			return false;
		else
			return true;
	}
}

package exercise.list;
import datastructure.list.DBLinkedList;
public class DBLinkedListMain {
	public static void main(String[] args) {
		DBLinkedList<Integer> list = new DBLinkedList<Integer>();
		list.insert(5);
		list.insert(22);
		list.insertFront(33);
		list.insertFront(22);
		list.insertFront(1);
		
		System.out.println("현재 데이터의 수: "+list.count());
		
		System.out.print(list.first() + " ");
		for(int i=1; i<list.count(); i++) {
			System.out.print(list.next() + " ");
		}
		for(int i=1; i<list.count(); i++) {
			System.out.print(list.previous() + " ");
		}
		System.out.println();
		System.out.println();

		int listNum = list.count();
		if(list.first() == 22) {
			list.remove();
		}
		for(int i=1; i<listNum; i++) {
			if(list.next() == 22) {
				list.remove();
			}
		}

		System.out.print(list.first() + " ");
		for(int i=1; i<list.count(); i++) {
			System.out.print(list.next() + " ");
		}
	}
}

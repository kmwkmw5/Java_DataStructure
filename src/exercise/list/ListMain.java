package exercise.list;

import datastructure.list.*;

public class ListMain {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		//List<Integer> list = new LinkedList<Integer>();
		//List<Integer> list = new IntLinkedList();
		list.insert(22);
		list.insert(11);
		list.insert(13);
		list.insert(22);
		list.insert(33);
		
		System.out.println("현재 데이터의 수: "+list.count());
		list.printAllData(", ");
		list.setFirst();
		list.printAllData();
		/*
		//System.out.print(list.first() + " ");
		for(int i=0; i<list.count(); i++) {
			System.out.print(list.next() + " ");
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
		}*/
	}
}

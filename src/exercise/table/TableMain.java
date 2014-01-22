package exercise.table;

import datastructure.table.Table;

public class TableMain {
	public static void main(String[] args) {
		Table<Integer, Person> tb = new Table<Integer, Person>(new MyHashFunc<Integer>());
		
		Person p1 = new Person(200901, "김민우", "서울 도봉");
		Person p2 = new Person(201242, "권혜민", "천안 성환");
		Person p3 = new Person(202089, "가나다", "제주도");
		
		tb.insert(p1.getSSN(), p1);
		tb.insert(p2.getSSN(), p2);
		tb.insert(p3.getSSN(), p3);
		tb.delete(p1.getSSN()).showPerInfo();
		
		tb.search(p2.getSSN()).showPerInfo();
	}
}

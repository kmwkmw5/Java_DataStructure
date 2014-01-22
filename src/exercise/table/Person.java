package exercise.table;

public class Person {
	private int ssn;
	private String name;
	private String addr;
	
	public Person(int ssn, String name, String addr) {
		this.ssn = ssn;
		this.name = name;
		this.addr = addr;
	}
	
	public int getSSN() {
		return ssn;
	}
	
	public void showPerInfo() {
		System.out.println("번호: " + ssn);
		System.out.println("이름: " + name);
		System.out.println("주소: " + addr);
		System.out.println();
	}
}

package exercise.list.staff;
import datastructure.list.CLinkedList;
public class StaffHandler extends CLinkedList<Staff> {
	private boolean findName(String name) {
		if(this.first().getName().equals(name)) {
			return true;
		}
		else {
			for(int i=1; i<this.numOfData; i++) {
				if(this.next().getName().equals(name))
					return true;
			}
		}
		return false;
	}
	public String nextDuty(String name, int day) {
		if(findName(name)) {
			for(int i=0; i<day; i++) {
				this.next();
			}
			return this.cur.data.getName();
		}
		else {
			return name + "은(는) 당직 직원이 아닙니다.";
		}
	}
	
	public void showDutySequence() {
		System.out.print(this.first().getName());
		for(int i=1; i<this.numOfData; i++) {
			System.out.print(" -> " + this.next().getName());
		}
		System.out.println();
	}
	public void showDutySequence(int num) {
		System.out.print(this.first().getName());
		for(int i=1; i<this.numOfData*num; i++) {
			System.out.print(" -> " + this.next().getName());
		}
		System.out.println();
	}
}

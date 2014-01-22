package exercise.list.staff;
public class DutyMain {
	public static void main(String[] args) {
		StaffHandler staffList = new StaffHandler();
		
		staffList.insert(new Staff(1, "일당이"));
		staffList.insert(new Staff(2, "이당이"));
		staffList.insert(new Staff(3, "삼당이"));
		staffList.insert(new Staff(4, "사당이"));
		
		// 당직 순서를 3번 출력
		staffList.showDutySequence(3);
		
		System.out.println(staffList.nextDuty("삼당이", 14));
	}
}

package exercise.list;
import datastructure.list.ArrayList;
public class PointListMain {
	public static void main(String[] args) {
		ArrayList<Point> list = new ArrayList<Point>();
		Point point = new Point();

		try {
			point.setPoint(2, 1);
			list.insert((Point)point.clone());
			
			point.setPoint(2, 2);
			list.insert((Point)point.clone());
			
			point.setPoint(3, 1);
			list.insert((Point)point.clone());
			
			point.setPoint(3, 2);
			list.insert((Point)point.clone());
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println("현재 데이터의 수: " + list.count());
		
		System.out.println(list.first());
		for(int i=1; i<list.count(); i++) {
			System.out.println(list.next());
		}
		System.out.println();
		System.out.println();

		int listNum = list.count();
		Point compPos = new Point(2, 0);
		if(list.first().getX() == compPos.getX()) {
			list.remove();
		}
		for(int i=1; i<listNum; i++) {
			if(list.next().getX() == compPos.getX()) {
				list.remove();
			}
		}

		listNum = list.count();
		System.out.println(list.first());
		for(int i=1; i<listNum; i++) {
			System.out.println(list.next());
		}
		
	}
}

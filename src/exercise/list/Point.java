package exercise.list;
public class Point implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point() { }
	public Point(int x) {
		xPos = x;
		yPos = 0;
	}
	public Point(int x, int y) {
		xPos = x;
		yPos = y;
	}

	public void setPoint(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public void setPoint(int x) {
		xPos = x;
	}
	public int getX() {
		return xPos;
	}
	public int getY() {
		return yPos;
	}
	
	public String toString() {
		String str = "xPos: " + xPos + ", yPos: " + yPos;
		return str;
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

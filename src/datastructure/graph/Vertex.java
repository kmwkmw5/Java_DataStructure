package datastructure.graph;

public enum Vertex {
	A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8), J(9);
	private int value;
	
	private Vertex(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public String toString() {
		switch(this) {
		case A:
			return "A";
		case B:
			return "B";
		case C:
			return "C";
		case D:
			return "D";
		case E:
			return "E";
		case F:
			return "F";
		case G:
			return "G";
		case H:
			return "H";
		case I:
			return "I";
		case J:
			return "J";
		default:
			return "";
		}
	}
}

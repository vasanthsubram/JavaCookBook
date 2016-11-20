package core.basicJava;

public class TestEquality {

	public static void main(String args[]) {
		System.out.println(new Point(1, 2).equals(new Point(1, 2)));

		System.out.println(new Point(1, 2).equals("Point"));
	}
}

class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// parameter for equals method must be of type Object,
	// otherwise your are overloading, not overriding
	public boolean equals(Object other) {
		if (other instanceof Point) {
			if (!(this == other)) {
				Point p = (Point) other;
				return ((this.x == p.x) && (this.y == p.y));
			}
		}

		return false;
	}

	public boolean equals(Point other) {
		if (!(this == other)) {
			Point p = (Point) other;
			return ((this.x == p.x) && (this.y == p.y));
		}
		return false;
	}
	
	//simple 
	public int hashCode(){
		return (x+y <= Integer.MAX_VALUE)? x+y : Integer.MAX_VALUE;
	}
}
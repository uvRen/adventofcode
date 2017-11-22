package adventofcode;

public class Point {
	private int x;
	private int y;
	
	Point() {
		this.x = 0;
		this.y = 0;
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void increaseX(int number) {
		this.x += number;
	}
	
	public void increaseY(int number) {
		this.y += number;
	}
}

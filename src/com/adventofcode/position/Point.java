package com.adventofcode.position;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
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
	
	public int distanceToOrigin() {
	    return Math.abs(this.x + this.y);
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Point) {
			Point p = (Point)object;
			if(p.x == this.x && p.y == this.y)
				return true;
		}
		return false;
	}
}

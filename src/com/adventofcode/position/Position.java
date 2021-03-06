package com.adventofcode.position;

import java.util.ArrayList;
import java.util.List;

public class Position {
    public enum Direction { NORTH, EAST, SOUTH, WEST };
	private Direction current;
	private Point point;
	
	public Position() {
		current = Direction.NORTH;
		point = new Point();
	}
	
	public Position(Direction direction) {
		current = direction;
		point = new Point();
	}
	
	public Position(Direction direction, Point point) {
        current = direction;
        this.point = point;
    }
	
	public int getX() {
		return this.point.getX();
	}
	
	public int getY() {
		return this.point.getY();
	}
	
	public int getXAbs() {
	    return Math.abs(this.point.getX());
	}
	
	public int getYAbs() {
        return Math.abs(this.point.getY());
    }
	
	public Point getCurrentPosition() {
		return this.point;
	}
	
	public void move(int steps) {
		switch(current) {
		case NORTH:
			point.increaseY(steps);
			break;
		case EAST:
			point.increaseX(steps);
			break;
		case SOUTH:
			point.increaseY(-steps);
			break;
		case WEST:
			point.increaseX(-steps);
			break;
		}
	}
	
	/**
	 * Returns all steps made and not just the endpoint.
	 * For example if you should move 6 steps, 6 moves
	 * are returned
	 * @param steps Number of steps that should be taken
	 * @return List with all steps taken
	 */
	public List<Point> moveAllSteps(int steps) {
		List<Point> moves = new ArrayList<Point>();
		for(int i=0; i < steps; i++) {
			move(1);
			moves.add(new Point(this.point.getX(), this.point.getY()));
		}
		return moves;
	}
	
	public void setDirection(Direction direction) {
	    this.current = direction;
	}
	
	public Direction getDirection() {
	    return this.current;
	}
	
	public void rotateToward(char rotation) {
		switch(current) {
		case NORTH:
			if(rotation == 'L')
				current = Direction.WEST;
			else
				current = Direction.EAST;
			break;
		case EAST:
			if(rotation == 'L')
				current = Direction.NORTH;
			else
				current = Direction.SOUTH;
			break;
		case SOUTH:
			if(rotation == 'L')
				current = Direction.EAST;
			else
				current = Direction.WEST;
			break;
		case WEST:
			if(rotation == 'L')
				current = Direction.SOUTH;
			else
				current = Direction.NORTH;
			break;
		}
	}
}

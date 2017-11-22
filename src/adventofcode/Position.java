package adventofcode;

enum Direction {
	NORTH,
	EAST,
	SOUTH,
	WEST
}

public class Position {
	
	private Direction current;
	private Point position;
	
	Position() {
		current = Direction.NORTH;
		position = new Point();
	}
	
	Position(Direction direction) {
		current = direction;
		position = new Point();
	}
	
	public int getX() {
		return this.position.getX();
	}
	
	public int getY() {
		return this.position.getY();
	}
	
	public void move(int steps) {
		switch(current) {
		case NORTH:
			position.increaseY(steps);
			break;
		case EAST:
			position.increaseX(steps);
			break;
		case SOUTH:
			position.increaseY(-steps);
			break;
		case WEST:
			position.increaseX(-steps);
			break;
		}
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

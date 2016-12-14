import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solve {
	enum DIRECTION {
		NORTH, SOUTH, WEST, EAST
	};
	DIRECTION direction = DIRECTION.NORTH;
	Point position;
	List<Point> visited;
	boolean found = false;
	
	public Solve() {
		visited = new ArrayList<Point>();
		position = new Point(0,0);
	}
	
	public void calculate() {
		try {
			Scanner sc = new Scanner(new File("instructions.txt"));
			while(sc.hasNext("\\w+,")) {
				String s = sc.next();
				calculateMove(position, s);
				if(found)
					break;
			}
			sc.close();
			System.out.println("Visited (" + position.x + "," + position.y + ") twice!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void calculateMove(Point oldPoint, String instruction) {
		char dir = instruction.charAt(0);
		int length = Integer.parseInt(instruction.substring(1, instruction.length()-1));
		switch(direction) {
		case NORTH:
			if(dir == 'L') {
				found = step(length, 'x', '-');
				direction = DIRECTION.WEST;
			}
			else {
				found = step(length, 'x', '+');
				direction = DIRECTION.EAST;
			}
			break;
		case SOUTH:
			if(dir == 'L') {
				found = step(length, 'x', '+');
				direction = DIRECTION.EAST;
			}
			else {
				found = step(length, 'x', '-');
				direction = DIRECTION.WEST;
			}
			break;
		case WEST:
			if(dir == 'L') {
				found = step(length, 'y', '-');
				direction = DIRECTION.SOUTH;
			}
			else {
				found = step(length, 'y', '+');
				direction = DIRECTION.NORTH;
			}
			break;
		case EAST:
			if(dir == 'L') {
				found = step(length, 'y', '+');
				direction = DIRECTION.NORTH;
			}
			else {
				found = step(length, 'y', '-');
				direction = DIRECTION.SOUTH;
			}
			break;
		}
	}
	
	private boolean step(int length, char coordinate, char sign) { 
		for(int i = 0; i < length; i++) {
			if(sign == '+' && coordinate == 'x') {
				position.x += 1;
			}
			else if(sign == '+' && coordinate == 'y') {
				position.y += 1;
			}
			else if(sign == '-' && coordinate == 'x') {
				position.x -= 1;
			}
			else if(sign == '-' && coordinate == 'y') {
				position.y -= 1;
			}
			if(addPointToList())
				return true;
		}
		return false;
	}
	
	private boolean addPointToList() {
		Point p = new Point();
		p = (Point)position.clone();
		if(visited.contains(p)) {
			return true;
		}
		visited.add(p);
		return false;
	}
	
}

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
	boolean found = false;
	
	public Solve() {
		position = new Point(0,0);
	}
	
	public void calculate() {
		try {
			Scanner sc = new Scanner(new File("instructions.txt"));
			while(sc.hasNext("\\w+,")) {
				String s = sc.next();
				calculateMove(position, s);
			}
			sc.close();
			System.out.println("End position (" + position.x + "," + position.y + ")");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Point calculateMove(Point oldPoint, String instruction) {
		char dir = instruction.charAt(0);
		int length = Integer.parseInt(instruction.substring(1, instruction.length()-1));
		Point p = new Point(0,0);
		switch(direction) {
		case NORTH:
			if(dir == 'L') {
				for(int i = 0; i < length; i++) {
					oldPoint.x -= 1;
				}
				direction = DIRECTION.WEST;
			}
			else {
				for(int i = 0; i < length; i++) {
					oldPoint.x += 1;
				}
				direction = DIRECTION.EAST;
			}
			break;
		case SOUTH:
			if(dir == 'L') {
				for(int i = 0; i < length; i++) {
					oldPoint.x += 1;
				}
				direction = DIRECTION.EAST;
			}
			else {
				for(int i = 0; i < length; i++) {
					oldPoint.x -= 1;
				}
				direction = DIRECTION.WEST;
			}
			break;
		case WEST:
			if(dir == 'L') {
				for(int i = 0; i < length; i++) {
					oldPoint.y -= 1;
				}
				direction = DIRECTION.SOUTH;
			}
			else {
				for(int i = 0; i < length; i++) {
					oldPoint.y += 1;
				}
				direction = DIRECTION.NORTH;
			}
			break;
		case EAST:
			if(dir == 'L') {
				for(int i = 0; i < length; i++) {
					oldPoint.y += 1;
				}
				direction = DIRECTION.NORTH;
			}
			else {
				for(int i = 0; i < length; i++) {
					oldPoint.y -= 1;
				}
				direction = DIRECTION.SOUTH;
			}
			break;
		}
		p = (Point)oldPoint.clone();
		return p;
	}

}

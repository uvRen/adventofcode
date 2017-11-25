package adventofcode;

import java.util.ArrayList;
import java.util.List;

public class SolutionFinder {
	public static int solveDay1Task1() {
		String fileContent = FileHandler.getContentOfFile("Inputs/Day1/input.txt");
		Position position  = new Position();
		String[] movements = fileContent.split(", ");
		
		for(String move : movements) {
			position.rotateToward(move.charAt(0));
			position.move(Integer.parseInt(move.substring(1)));
		}
		
		return Math.abs(position.getX()) + Math.abs(position.getY());
	}
	
	public static int solveDay1Task2() {
		String fileContent 			= FileHandler.getContentOfFile("Inputs/Day1/input.txt");
		List<Point> visited    = new ArrayList<Point>();
		List<Point> moves 			= new ArrayList<Point>();
		String[] movements 			= fileContent.split(", ");
		Point found 				= null;
		Position position 			= new Position();
		int steps 					= 0;
		
		for(String move : movements) {
			position.rotateToward(move.charAt(0));
			steps = Integer.parseInt(move.substring(1));
			moves = position.moveAllSteps(steps);
			
			for(Point p : moves) {
				if(visited.contains(p)) {
					found = p;
					break;
				}
			}
			if(found != null)
				break;
			visited.addAll(moves);
		}
		
		return Math.abs(found.getX()) + Math.abs(found.getY());
	}
}

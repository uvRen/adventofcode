package adventofcode;

public class SolutionFinder {
	public static int solveDay1Task1() {
		String fileContent = FileHandler.getContentOfFile("Inputs/Day1/input.txt");
		Position position = new Position();
		String[] movements = fileContent.split(", ");
		
		for(String move : movements) {
			position.rotateToward(move.charAt(0));
			position.move(Integer.parseInt(move.substring(1)));
		}
		
		return Math.abs(position.getX()) + Math.abs(position.getY());
	}
}

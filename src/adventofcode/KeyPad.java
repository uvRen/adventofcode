package adventofcode;

public class KeyPad {
	private String[][] standard = {
			{"1", "2", "3"},
			{"4", "5", "6"},
			{"7", "8", "9"}};
	private int currentRow = 1;
	private int currentColumn = 1;
	
	public String move(String commands) {
		for(int i = 0; i < commands.length(); i++) {
			move(commands.charAt(i));
		}
		return standard[currentRow][currentColumn];
	}
	
	private void move(char c) {
		switch(c) {
		case 'U':
			currentRow = (currentRow == 0) ? currentRow = 0 : (currentRow = currentRow - 1); 
			break;
		case 'R':
			currentColumn = (currentColumn == 2) ? currentColumn = 2 : (currentColumn = currentColumn + 1);
			break;
		case 'D':
			currentRow = (currentRow == 2) ? currentRow = 2 : (currentRow = currentRow + 1); 
			break;
		case 'L':
			currentColumn = (currentColumn == 0) ? currentColumn = 0 : (currentColumn = currentColumn - 1);
			break;
		}
	}
}

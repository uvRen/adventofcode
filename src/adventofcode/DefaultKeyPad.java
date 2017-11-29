package adventofcode;

public class DefaultKeyPad implements IKeyPad {
	private String[][] keypad = {
			{"1", "2", "3"},
			{"4", "5", "6"},
			{"7", "8", "9"}};
	private int maxRowIndex = 2;
	private int maxColumnIndex = 2;
	private int currentRow = 1;
	private int currentColumn = 1;
	
	@Override
	public String move(String commands) {
		for(int i = 0; i < commands.length(); i++) {
			move(commands.charAt(i));
		}
		return keypad[currentRow][currentColumn];
	}
	
	private void move(char c) {
		switch(c) {
		case 'U':
			goUp(); 
			break;
		case 'R':
			goRight();
			break;
		case 'D':
			goDown();
			break;
		case 'L':
			goLeft();
			break;
		}
	}
	
	private void goLeft() {
		if(currentColumn == 0)
			return;
		currentColumn--;
	}
	
	private void goRight() {
		if(currentColumn == maxRowIndex)
			return;
		currentColumn++;
	}
	
	private void goUp() {
		if(currentRow == 0)
			return;
		currentRow--;
	}
	
	private void goDown() {
		if(currentRow == maxColumnIndex)
			return;
		currentRow++;
	}
}

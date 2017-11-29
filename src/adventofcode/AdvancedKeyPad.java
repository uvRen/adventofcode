package adventofcode;

public class AdvancedKeyPad implements IKeyPad {
	private String[][] keypad = {
			{"-", "-", "1", "-", "-"},
			{"-", "2", "3", "4", "-"},
			{"5", "6", "7", "8", "9"},
			{"-", "A", "B", "C", "-"},
			{"-", "-", "D", "-", "-"}};
	private int maxRowIndex = 4;
	private int maxColumnIndex = 4;
	private int currentRow = 2;
	private int currentColumn = 0;
	
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
		else if(keypad[currentRow][currentColumn - 1] == "-")
			return;
		currentColumn--;
	}
	
	private void goRight() {
		if(currentColumn == maxColumnIndex)
			return;
		else if(keypad[currentRow][currentColumn + 1] == "-")
			return;
		currentColumn++;
	}
	
	private void goUp() {
		if(currentRow == 0)
			return;
		else if(keypad[currentRow - 1][currentColumn] == "-")
			return;
		currentRow--;
	}
	
	private void goDown() {
		if(currentRow == maxRowIndex)
			return;
		else if(keypad[currentRow + 1][currentColumn] == "-")
			return;
		currentRow++;
	}

}

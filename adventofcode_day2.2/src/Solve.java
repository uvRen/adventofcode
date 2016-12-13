import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solve {

	enum SIGN {ADD, SUB}
	enum PAD {ROW, COLUMN}
	private LinkedList<String> code;
	private String[][] numpad = {{"", "", "1", "", ""},
							 	 {"", "2", "3", "4", ""},
							 	 {"5", "6", "7", "8", "9"},
							 	 {"", "A", "B", "C", ""},
							 	 {"", "", "D", "", ""}
	
	};
	private int row;
	private int col;
	
	public Solve() {
		//Start at '5' = numpad[2][0]
		row = 2;
		col = 0;
		code = new LinkedList<String>();
	}
	
	
	public void calulate() {
		try {
			Scanner sc = new Scanner(new File("instructions.txt"));
			while(sc.hasNextLine()) {
				String r = sc.nextLine();
				for(int i = 0; i < r.length(); i++) {
					calculateRow(r.charAt(i));
				}
				code.add("" + numpad[row][col]);
			}
			sc.close();
			System.out.println(code);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void calculateRow(char c) {
		switch(c) {
		case 'U':
			if(validateMove(PAD.ROW, SIGN.SUB))
				row -= 1;
			break;
		case 'D':
			if(validateMove(PAD.ROW, SIGN.ADD))
				row += 1;
			break;
		case 'L':
			if(validateMove(PAD.COLUMN, SIGN.SUB))
				col -= 1;
			break;
		case 'R':
			if(validateMove(PAD.COLUMN, SIGN.ADD))
				col += 1;
			break;
		}
	}
	
	private boolean validateMove(PAD pad, SIGN sign) {
	switch(sign) {
		case ADD:
		if(pad == PAD.ROW) {
			if((row + 1) > 4)
				return false;
			if(numpad[row+1][col].equals(""))
				return false;
		}
		else if(pad == PAD.COLUMN) {
			if((col + 1) > 4)
				return false;
			if(numpad[row][col+1].equals(""))
				return false;
		}
			break;
		case SUB:
			if(pad == PAD.ROW) {
				if((row - 1) < 0)
					return false;
				if(numpad[row-1][col].equals(""))
					return false;
			}
			else if(pad == PAD.COLUMN) {
				if((col - 1) < 0)
					return false;
				if(numpad[row][col-1].equals(""))
					return false;
			}
			break;
	}
	return true;
	}
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solve {
	private LinkedList<String> code;
	private int[][] numpad = 	{{1,2,3},
					 			 {4,5,6},
					 			 {7,8,9}
								};
	private int row;
	private int col;
	
	public Solve() {
		//Start at '5' = numpad[1][1]
		row = 1;
		col = 1;
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
			if((row -= 1) < 0)
				row = 0;
			break;
		case 'D':
			if((row += 1) > 2)
				row = 2;
			break;
		case 'L':
			if((col -= 1) < 0)
				col = 0;
			break;
		case 'R':
			if((col += 1) > 2)
				col = 2;
			break;
		}
	}
}

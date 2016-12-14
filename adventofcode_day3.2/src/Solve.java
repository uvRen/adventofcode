import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Triangle {
	private int a, b, c;
	
	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public boolean valid() {
		if((a + b) > c) {
			if((a + c) > b) {
				if((b + c) > a)
					return true;
			}
		}
		return false;
	}
};

public class Solve {
	private int[][] table;
	private int currentRow = 0;
	public Solve() {
		table = new int[2000][3];
	}
	
	public void calculate() {
		Scanner sc;
		int count = 0;
		try {
			sc = new Scanner(new File("instructions.txt"));
			while(sc.hasNextLine()) {
				fillTable(sc.nextLine());
			}
			
			System.out.println("Valid triangle: " + validateTriangles());
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private int validateTriangles() {
		int count = 0;
		for(int row = 0; row < currentRow; row += 3) {
			for(int col = 0; col < 3; col++) {
				Triangle t = new Triangle(table[row][col], table[row+1][col], table[row+2][col]);
				if(t.valid())
					count++;
			}
		}
		return count;
	}
	
	private void fillTable(String row) {
		row = row.trim();
		String cols[] = row.split("\\s+");
		for(int i = 0; i < 3; i++) {
			try {
				table[currentRow][i] = Integer.parseInt(cols[i].trim());
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		currentRow++;
	}
}

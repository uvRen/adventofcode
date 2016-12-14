import java.io.File;
import java.io.FileNotFoundException;
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
	public Solve() {
	}
	
	public void calculate() {
		Scanner sc;
		int count = 0;
		try {
			sc = new Scanner(new File("instructions.txt"));
			while(sc.hasNextLine()) {
				String row = sc.nextLine();
				if(validTriangle(row)) {
					count++;
				}
			}
			System.out.println("Valid triangle: " + count);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private boolean validTriangle(String row) {
		Scanner sc = new Scanner(row);
		Triangle t = new Triangle(sc.nextInt(), sc.nextInt(), sc.nextInt());
		sc.close();
		return t.valid();
	}
}

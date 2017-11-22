package adventofcode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
	public static String getContentOfFile(String path) {
		Scanner scanner = null;
		String content = "";
		
		try {
			scanner = new Scanner(new File(path));
			content += scanner.nextLine();
		} catch (IOException e) {
			
		} finally {
			scanner.close();
		}
		return content;
	}
}

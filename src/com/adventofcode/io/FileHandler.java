package com.adventofcode.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
	
	private static String getContentOfFile(String path, boolean newline) {
		Scanner scanner = null;
		StringBuilder sb = null;
		
		try {
			scanner = new Scanner(new File(path));
			sb = new StringBuilder();
			while(scanner.hasNextLine()) {
				sb.append(scanner.nextLine());
				if(newline) {
					sb.append(System.lineSeparator());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't find '" + path + "'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return sb.toString();
	}
	
	/**
	 * Gets all content of the file
	 * @param path Path to the file to read
	 * @return String with the content of the file
	 */
	public static String getContentOfFile(String path) {
		return getContentOfFile(path, false);
	}
	
	/**
	 * Gets the content from the file and returns it as a list
	 * where each item in the list represents one row in the file
	 * @param path Path to the file to read
	 * @return List<String> where each item represents one row in the file
	 */
	public static List<String> getEachRowFromFile(String path) {
		List<String> rows = new ArrayList<String>();
		String[] content = getContentOfFile(path, true).split(System.lineSeparator());
		for(String s : content) {
			rows.add(s);
		}
		return rows;
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Data implements Comparable<Data> {
	private Character c;
	private int occur;
	
	public Data(char c) {
		this.c = c;
		this.occur = 1;
	}
	
	public char getChar() {
		return c;
	}
	
	public void increase() {
		occur += 1;
	}
	
	@Override
	public boolean equals(Object o) {
		Data d = (Data)o;
		if(c.compareTo(d.c) == 0)
			return true;
		return false;
	}

	@Override
	public int compareTo(Data d) {
		if(occur > d.occur)
			return -1;
		else if(occur < d.occur)
			return 1;
		else {
			return c.compareTo(d.c);
		}
	}
	
	@Override
	public String toString() {
		return c + "=" + occur;
	}
}

public class Solve {
	private List<Data> map;
	private int totalSum = 0;
	
	public Solve() {
		map = new ArrayList<Data>();
	}
	
	public void calculate() {
		try {
			Scanner sc = new Scanner(new File("instructions.txt"));
			while(sc.hasNextLine()) {
				processRow(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void processRow(String row) {
		String code = row.substring(0, row.indexOf('['));
		String checksum = returnClearChecksum(row.substring(row.indexOf('[')));
		countChars(code);
		Collections.sort(map);
		if(validRoom(checksum)) {
			totalSum += getSectorID(code);
			String decryptedName = decrypt(code);
			if(decryptedName.contains("northpole"))
				System.out.println(decryptedName + " " + getSectorID(code));
		}
		map.clear();
	}
	
	private boolean validRoom(String checksum) {
		for(int i = 0; i < checksum.length(); i++) {
			if(checksum.charAt(i) != map.get(i).getChar())
				return false;
		}
		return true;
	}
	
	private void countChars(String code) {
		String reformatCode = returnClearCode(code);
		for(char c : reformatCode.toCharArray()) {
			if(c != '-') {
				addToList(c);
			}
		}
	}
	
	private String decrypt(String code) {
		String roomname = returnClearCodeWithDashes(code);
		StringBuilder name = new StringBuilder();
		int sectionID = getSectorID(code);
		
		for(int i = 0; i < roomname.length(); i++) {
			if(roomname.charAt(i) == '-')
				name.append(' ');
			else {
				name.append(decryptChar(roomname.charAt(i), sectionID));
			}
		}
		
		return name.toString();
	}
	
	private char decryptChar(char c, int sectionID) {
		int section = sectionID % 26;
		char newC = c;
		for(int i = 0; i < section; i++) {
			if(newC == 'z')
				newC = 'a';
			else
				newC = (char)(newC + 1);
		}
		return newC;
	}
	
	private void addToList(char c) {
		Data data = new Data(c);
		if(map.contains(data)) {
			Data toBeIncreased = null;
			for(Data d : map) 
				if(d.equals(data))
					toBeIncreased = d;
			toBeIncreased.increase();
		}
		else {
			map.add(data);
		}
	}
	
	private int getSectorID(String code) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(code);
		
		if(m.find()) {
			return Integer.parseInt(m.group());
		}
		return -1;
	}
	
	private String returnClearCode(String code) {
		Pattern p = Pattern.compile("(\\w+-)+");
		Matcher m = p.matcher(code);
		
		if(m.find()) {
			return m.group().replaceAll("-", "");
		}
		return "";
	}
	
	private String returnClearCodeWithDashes(String code) {
		Pattern p = Pattern.compile("(\\w+-)+");
		Matcher m = p.matcher(code);
		
		if(m.find()) {
			String s = m.group();
			return s.substring(0, s.length() - 1);
		}
		return "";
	}
	
	private String returnClearChecksum(String checksum) {
		Pattern p = Pattern.compile("\\[\\w+\\]");
		Matcher m = p.matcher(checksum);
		
		if(m.find()) {
			return m.group().replaceAll("[\\[ | \\]]", "");
		}
		return "";
	}
}
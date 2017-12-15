package com.adventofcode.soltionfinder;

import java.util.List;

import com.adventofcode.io.FileHandler;
import com.adventofcode.memory.MemoryBank;
import com.adventofcode.tree.Tree;
import com.adventofcode.tree.TreeNode;
import com.adventofcode.util.CircularList;
import com.adventofcode.util.ListMover;
import com.adventofcode.util.MathHelper;
import com.adventofcode.util.SpiralMemory;
import com.adventofcode.util.SpiralMemoryMathematical;
import com.adventofcode.word.WordCounter;

public class SolutionFinder2017 {
	
	public static int solveDay1Task1() {
	    String file = FileHandler.getContentOfFile("Inputs/2017/Day1/input.txt");
	    file += file.charAt(file.length() - 1);
	    int sum = 0;
	    for(int i = 0; i < file.length() - 1; i++) {
	        if(file.charAt(i) == file.charAt(i+1))
	            sum += Integer.parseInt("" + file.charAt(i));
	    }
	    return sum;
	}
	
	public static int solveDay1Task2() {
        String file = FileHandler.getContentOfFile("Inputs/2017/Day1/input.txt");
        CircularList list = new CircularList(file.length() / 2);
        list.convertStringToList(file);
        int sum = 0;
        for(int i = 0; i < file.length(); i++) {
            if(list.getStringAt(i).equals(list.getStringAtWithOffset(i))) {
                sum += Integer.parseInt("" + list.getStringAt(i));
            }
        }
        return sum;
    }

	public static int solveDay2Task1() {
	    List<String> rows = FileHandler.getEachRowFromFile("Inputs/2017/Day2/input.txt");
	    int sum = 0;
	    MathHelper math = new MathHelper();
	    for(String row : rows) {
	        sum += (math.getMaxValueFromRow(row) - math.getMinValueFromRow(row));
	    }
	    return sum;
	}
	
	public static int solveDay2Task2() {
        List<String> rows = FileHandler.getEachRowFromFile("Inputs/2017/Day2/input.txt");
        int sum = 0;
        MathHelper math = new MathHelper();
        for(String row : rows) {
            sum += math.findAndDevideTwoEvenlyNumbers(row);
        }
        return sum;
    }
	
	public static int solveDay3Task1() {
        SpiralMemoryMathematical memory = new SpiralMemoryMathematical();
        return memory.findNumber(325489);
    }
    
    public static int solveDay3Task2() {
        SpiralMemory memory = new SpiralMemory();
        return memory.findNumber(325489);
    }
	
	public static int solveDay4Task1() {
	    List<String> rows = FileHandler.getEachRowFromFile("Inputs/2017/Day4/input.txt");
	    WordCounter counter = new WordCounter();
	    int validRows = 0;
	    for(String row : rows) {
	        if(!counter.hasRowDuplicateWords(row))
	            validRows++;
	    }
	    return validRows;
	}
	
	public static int solveDay4Task2() {
	    List<String> rows = FileHandler.getEachRowFromFile("Inputs/2017/Day4/input.txt");
	    WordCounter counter = new WordCounter();
	    int validRows = 0;
	    for(String row : rows) {
            if(!counter.hasRowAnagrams(row))
                validRows++;
        }
        return validRows;
	}
	
	public static int solveDay5Task1() {
	    List<Integer> numbers = FileHandler.getEachRowFromFileAsIntegers("Inputs/2017/Day5/input.txt");
	    ListMover mover = new ListMover(numbers);
	    return mover.startStepping(false);
    }
	
	public static int solveDay5Task2() {
        List<Integer> numbers = FileHandler.getEachRowFromFileAsIntegers("Inputs/2017/Day5/input.txt");
        ListMover mover = new ListMover(numbers);
        return mover.startStepping(true);
    }
	
	public static int solveDay6Task1() {
	    String content = FileHandler.getContentOfFile("Inputs/2017/Day6/input.txt");
	    MemoryBank memory = new MemoryBank();
	    memory.initializeMemoryBank(content);
	    int iterations = memory.redistributeMemory(false);
	    return iterations;
	}
	
	public static int solveDay6Task2() {
        String content = FileHandler.getContentOfFile("Inputs/2017/Day6/input.txt");
        MemoryBank memory = new MemoryBank();
        memory.initializeMemoryBank(content);
        int iterations = memory.redistributeMemory(true);
        return iterations;
    }
	
	public static String solveDay7Task1() {
        List<String> rows = FileHandler.getEachRowFromFile("Inputs/2017/Day7/input.txt");
        Tree tree = new Tree();
        tree.buildTree(rows);
        return tree.getRoot().getName();
	}
	
	public static int solveDay7Task2() {
        List<String> rows = FileHandler.getEachRowFromFile("Inputs/2017/Day7/input.txt");
        Tree tree = new Tree();
        tree.buildTree(rows);
        TreeNode nodeWithWrongWeight = tree.findUnbalancedNodeFromTop();
        return nodeWithWrongWeight.getWeight() - 5;
    }
}

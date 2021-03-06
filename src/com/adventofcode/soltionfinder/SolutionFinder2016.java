package com.adventofcode.soltionfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.adventofcode.io.FileHandler;
import com.adventofcode.keypad.AdvancedKeyPad;
import com.adventofcode.keypad.DefaultKeyPad;
import com.adventofcode.keypad.IKeyPad;
import com.adventofcode.position.Point;
import com.adventofcode.position.Position;
import com.adventofcode.util.RoomDecoder;
import com.adventofcode.util.Triangle;

public class SolutionFinder2016 {
    public static int solveDay1Task1() {
        String fileContent = FileHandler.getContentOfFile("Inputs/Day1/input.txt");
        Position position  = new Position();
        String[] movements = fileContent.split(", ");
            
        for(String move : movements) {
            position.rotateToward(move.charAt(0));
            position.move(Integer.parseInt(move.substring(1)));
        }
        
        return Math.abs(position.getX()) + Math.abs(position.getY());
    }
    
    public static int solveDay1Task2() {
        String fileContent          = FileHandler.getContentOfFile("Inputs/Day1/input.txt");
        List<Point> visited         = new ArrayList<Point>();
        List<Point> moves           = new ArrayList<Point>();
        String[] movements          = fileContent.split(", ");
        Point found                 = null;
        Position position           = new Position();
        int steps                   = 0;
        
        for(String move : movements) {
            position.rotateToward(move.charAt(0));
            steps = Integer.parseInt(move.substring(1));
            moves = position.moveAllSteps(steps);
            
            for(Point p : moves) {
                if(visited.contains(p)) {
                    found = p;
                    break;
                }
            }
            if(found != null)
                break;
            visited.addAll(moves);
        }
        
        return Math.abs(found.getX()) + Math.abs(found.getY());
    }
    
    public static String solveDay2Task1() {
        List<String> rows = FileHandler.getEachRowFromFile("Inputs/Day2/input.txt");
        IKeyPad keypad = new DefaultKeyPad();
        String code = "";
        for(String row : rows) {
            code += keypad.move(row);
        }
        return code;
    }
    
    public static String solveDay2Task2() {
        List<String> rows = FileHandler.getEachRowFromFile("Inputs/Day2/input.txt");
        IKeyPad keypad = new AdvancedKeyPad();
        String code = "";
        for(String row : rows) {
            code += keypad.move(row);
        }
        return code;
    }
    
    public static int solveDay3Task1() {
        List<String> rows = FileHandler.getEachRowFromFile("Inputs/Day3/input.txt");
        Triangle triangle = new Triangle();
        int validTriangles = 0;
        Scanner scanner = null;
        for(String row : rows) {
            scanner = new Scanner(row);
            triangle.updateTriangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            if(triangle.isValid())
                validTriangles++;
        }
        return validTriangles;
    }
    
    public static int solveDay3Task2() {
        List<String> rows = FileHandler.getEachRowFromFile("Inputs/Day3/input.txt");
        Triangle triangle = new Triangle();
        int validTriangles = 0;
        Scanner scanner1 = null;
        Scanner scanner2 = null;
        Scanner scanner3 = null;
        String row1 = "";
        String row2 = "";
        String row3 = "";
        
        for(int i = 0; i < rows.size() - 2; i = i + 3) {
            row1 = rows.get(i);
            row2 = rows.get(i + 1);
            row3 = rows.get(i + 2);
            
            scanner1 = new Scanner(row1);
            scanner2 = new Scanner(row2);
            scanner3 = new Scanner(row3);
            
            triangle.updateTriangle(scanner1.nextInt(), scanner2.nextInt(), scanner3.nextInt());
            if(triangle.isValid())
                validTriangles++;
            
            triangle.updateTriangle(scanner1.nextInt(), scanner2.nextInt(), scanner3.nextInt());
            if(triangle.isValid())
                validTriangles++;
            
            triangle.updateTriangle(scanner1.nextInt(), scanner2.nextInt(), scanner3.nextInt());
            if(triangle.isValid())
                validTriangles++;
        }
        return validTriangles;
    }

    public static int solveDay4Task1() {
        List<String> rows = FileHandler.getEachRowFromFile("Inputs/Day4/input.txt");
        RoomDecoder decoder = new RoomDecoder();
        for(String row : rows) {
            decoder.decode(row);
        }
        return 1;
    }
}

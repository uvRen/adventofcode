package com.adventofcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathHelper {
    
    public MathHelper() {
        
    }
    
    public int getMaxValueFromRow(String row) {
        int max = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(row);
        while(scanner.hasNextInt()) {
            max = Math.max(max, scanner.nextInt());
        }
        scanner.close();
        return max;
    }
    
    public int getMinValueFromRow(String row) {
        int max = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(row);
        while(scanner.hasNextInt()) {
            max = Math.min(max, scanner.nextInt());
        }
        scanner.close();
        return max;
    }
    
    public int findAndDevideTwoEvenlyNumbers(String row) {
        Scanner scanner = new Scanner(row);
        List<Integer> numbers = new ArrayList<Integer>();
        // Add all numbers to a list
        while(scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        scanner.close();
        int size = numbers.size();
        // Divide all numbers with each other to find those that are evenly divided
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                if(numbers.get(i) % numbers.get(j) == 0) {
                    return numbers.get(i) / numbers.get(j);
                }
            }
        }
        for(int i = size - 1; i > 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(numbers.get(i) % numbers.get(j) == 0) {
                    return numbers.get(i) / numbers.get(j);
                }
            }
        }
        return 0;
    }
}

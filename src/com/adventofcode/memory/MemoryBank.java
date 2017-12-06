package com.adventofcode.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryBank {
    private List<Memory> bank;
    private List<String> states;
    
    public MemoryBank() {
        bank = new ArrayList<Memory>();
        states = new ArrayList<String>();
    }
    
    public int redistributeMemory() {
        int iterations = 0;
        String stateToLookFor = "";
        int found = 0;
        boolean skipAdd = false;
        while(true) {
            int index = findBiggestMemory();
            int distribute = bank.get(index).getSize();
            bank.get(index).cleanMemory();
            
            while(distribute > 0) {
                index = increaseMemoryIndex(index);
                bank.get(index).increaseSize();
                distribute--;
            }
            
            iterations++;
            if(sameState(getMemoryStates()) && found == 0) {
                iterations = 0;
                stateToLookFor = getMemoryStates();
                states.clear();
                found++;
                skipAdd = true;
            } else if(states.contains(stateToLookFor) && found == 1) {
                iterations--;
                break;
            }
            if(!skipAdd)
                states.add(getMemoryStates());
            skipAdd = false;
        }
        return iterations;
    }
    
    private int increaseMemoryIndex(int index) {
        index++;
        if(index >= bank.size())
            index = 0;
        return index;
    }
    
    public void initializeMemoryBank(String content) {
        Scanner scanner = new Scanner(content);
        while(scanner.hasNext()) {
            bank.add(new Memory(scanner.nextInt()));
        }
        scanner.close();
    }
    
    /**
     * Return the index of the largest memory in the list
     * @return
     */
    public int findBiggestMemory() {
        int position = 0;
        int size = 0;
        
        for(int i = 0; i < bank.size(); i++) {
            if(bank.get(i).getSize() > size) {
                size = bank.get(i).getSize();
                position = i;
            }
        }
        
        return position;
    }
    
    public String getMemoryStates() {
        String state = "";
        for(Memory m : bank) {
            state += m.getSize();
        }
        return state;
    }
    
    public void addCurrentStateToList() {
        states.add(getMemoryStates());
    }
    
    public boolean sameState(String newState) {
        return states.contains(newState);
    }
}

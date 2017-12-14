package com.adventofcode.util;

import java.util.List;

public class ListMover {
    private List<Integer> list;
    private int min;
    private int max;
    private int steps = 0;
    
    public ListMover(List<Integer> list) {
        this.list = list;
        min = 0;
        max = list.size();
    }
    
    public int startStepping(boolean decrease) {
        int currentPosition = 0;
        int currentValue = 0;
        
        while(true) {
            currentValue = list.get(currentPosition);
            if(decrease) {
                if(currentValue >= 3)
                    list.set(currentPosition, currentValue - 1);
                else
                    list.set(currentPosition, currentValue + 1);
            } else {
                list.set(currentPosition, currentValue + 1);
            }
            currentPosition += currentValue;
            this.steps++;
            if(currentPosition < min || currentPosition >= max)
                break;
        }
        
        return this.steps;
    }
}

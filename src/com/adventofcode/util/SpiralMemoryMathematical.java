package com.adventofcode.util;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.position.Point;

public class SpiralMemoryMathematical {
    
    protected int multiplier = 8;
    protected int radius = 0;
    protected List<Integer> adders;
    
    public SpiralMemoryMathematical() {
        adders = new ArrayList<Integer>();
        adders.add(1);
    }

    /**
     * Returns the distance to the found number from 0 
     * @param number Number that we are looking for
     * @return The distance from the number to 0
     */
    public int findNumber(int number) {
        if(number == 1) {
            return 0;
        }

        this.radius = findRadius(number);
        return startSearching(this.radius, number);
    }
    
    protected int startSearching(int radius, int number) {
        Point position = new Point(radius, -radius);
        int numberAtPosition = sumPreviousNumbers() + (multiplier * radius);
        int rowLength = multiplier * radius / 4;
        int positionsAway = numberAtPosition - number;
        int side = 0;
        
        while(positionsAway > rowLength) {
            positionsAway -= rowLength;
            side++;
        }
        
        switch(side) {
        case 0:
            position.increaseX(-positionsAway);
            break;
        case 1:
            position.increaseY(positionsAway);
            position.increaseX(-position.getX() * 2);
            break;
        case 2:
            position.increaseX(-(rowLength - positionsAway));
            position.increaseY(-position.getY() * 2);
            break;
        case 3:
            position.increaseY(positionsAway);
            break;
        }
        
        return position.distanceToOrigin();
    }
    
    protected int findRadius(int number) {
        int i = 1;
        while((sumPreviousNumbers() + (multiplier * i)) < number) {
            adders.add(multiplier * i);
            i++;
        }
        return i;
    }
    
    protected int sumPreviousNumbers() {
        int sum = 0;
        for(Integer num : adders) {
            sum += num;
        }
        return sum;
    }
}

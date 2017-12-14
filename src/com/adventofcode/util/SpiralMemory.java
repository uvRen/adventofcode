package com.adventofcode.util;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.position.Point;
import com.adventofcode.position.Position;
import com.adventofcode.position.Position.Direction;

public class SpiralMemory extends SpiralMemoryMathematical {
    
    private int[][] grid;
    private Position gridPosition;
    private Position realPosition;
    private int totalTurns = 8;
    private int turnsUntilIncrease = 7;
    private int currentNumber = 1;
    
    public SpiralMemory() {
        this.adders = new ArrayList<Integer>();
        this.adders.add(1);
    }
    
    @Override
    public int findNumber(int number) {
        if(number == 1) {
            return 0;
        }

        this.radius = findRadius(number);
        initGrid();
        return startSearching(this.radius, number);
    }
    
    @Override
    protected int startSearching(int radius, int number) {
        boolean check = true;
        while(currentNumber < number) {
            move(1);
            currentNumber = assignValueToGrid();
            turnsUntilIncrease--;
            
            if(turnsUntilIncrease == 0) {
                totalTurns += 8;
                turnsUntilIncrease = totalTurns;
                move(1);
                currentNumber = assignValueToGrid();
                turnsUntilIncrease--;
                switchDirection();
                check = false;
            }
            
            if(check)
                checkIfSwitchNeeded();
            
            check = true;
        }
        return currentNumber;
    }
    
    private int assignValueToGrid() {
        int value = getValueFromNeighbors();
        grid[gridPosition.getY()][gridPosition.getX()] = value;
        return value;
    }
    
    private int getValueFromNeighbors() {
        int sum = 0;
        // One row above
        sum += grid[gridPosition.getY() - 1][gridPosition.getX() - 1];
        sum += grid[gridPosition.getY() - 1][gridPosition.getX()];
        sum += grid[gridPosition.getY() - 1][gridPosition.getX() + 1];
        
        // Same row
        sum += grid[gridPosition.getY()][gridPosition.getX() - 1];
        sum += grid[gridPosition.getY()][gridPosition.getX()];
        sum += grid[gridPosition.getY()][gridPosition.getX() + 1];
        
        // One row below
        sum += grid[gridPosition.getY() + 1][gridPosition.getX() - 1];
        sum += grid[gridPosition.getY() + 1][gridPosition.getX()];
        sum += grid[gridPosition.getY() + 1][gridPosition.getX() + 1];
        
        return sum;
    }
    
    private void move(int steps) {
        gridPosition.move(steps);
        realPosition.move(steps);
    }
    
    private void checkIfSwitchNeeded() {
        if(Math.abs(realPosition.getX()) == Math.abs(realPosition.getY())) {
            switchDirection();
        }
    }
    
    private void initGrid() {
        // Add size just in case
        if(this.radius % 2 == 0) {
            this.radius++;
        } else {
            this.radius += 2;
        }
        grid = new int[this.radius][this.radius];
        
        for(int i = 0; i < this.radius; i++) {
            for(int j = 0; j < this.radius; j++) {
                grid[i][j] = 0;
            }
        }
        
        setOrigin();
        
        grid[gridPosition.getYAbs()][gridPosition.getXAbs() - 1] = 1;
        grid[gridPosition.getYAbs()][gridPosition.getXAbs()] = 1;
    }
    
    private void setOrigin() {
        this.gridPosition = new Position(Direction.NORTH, new Point((this.radius / 2) + 1, this.radius / 2));
        this.realPosition = new Position(Direction.NORTH, new Point(1, 0));
    }

    private void switchDirection() {
        switch(realPosition.getDirection()) {
        case NORTH:
            this.gridPosition.setDirection(Direction.WEST);
            this.realPosition.setDirection(Direction.WEST);
            break;
        case EAST:
            this.gridPosition.setDirection(Direction.NORTH);
            this.realPosition.setDirection(Direction.NORTH);
            break;
        case SOUTH:
            this.gridPosition.setDirection(Direction.EAST);
            this.realPosition.setDirection(Direction.EAST);
            break;
        case WEST:
            this.gridPosition.setDirection(Direction.SOUTH);
            this.realPosition.setDirection(Direction.SOUTH);
            break;
        }
    }
   
}

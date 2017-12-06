package com.adventofcode.memory;

public class Memory {
    private int size;
    
    public Memory(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void cleanMemory() {
        this.size = 0;
    }
    
    public void increaseSize() {
        this.size++;
    }
    
    public void decreaseSize() {
        if(this.size > 0)
            this.size--;
    }
}

package com.adventofcode.util;

public class Triangle {
    private int x;
    private int y;
    private int z;
    
    public Triangle() {}
    
    public Triangle(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public boolean isValid() {
        if((x + y) > z)
            if((y + z) > x)
                if((x + z) > y)
                    return true;
        return false;
    }
    
    public void updateTriangle(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

package com.adventofcode.util;

public class Pair implements Comparable<Pair> {
    String c;
    int count;
    
    Pair() {
        count = 0;
    }
    
    Pair(String c) {
        this.c = c;
        count = 1;
    }
    
    public String getString() {
        return this.c;
    }
    
    public void increaseCount() {
        this.count++;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Pair) {
            Pair p = (Pair)o;
            if(p.c.equals(c))
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Pair right) {
        if(count < right.count)
            return 1;
        else if(count > right.count)
            return -1;
        else if(count == right.count) {
            return c.compareTo(right.c);
        }
        return 0;
    }
}

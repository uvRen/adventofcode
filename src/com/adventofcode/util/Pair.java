package com.adventofcode.util;

public class Pair implements Comparable<Pair> {
    private String c;
    private int count;
    
    public Pair() {
        setCount(0);
    }
    
    public Pair(String c) {
        this.setChar(c);
        setCount(1);
    }
    
    public void increaseCount() {
        this.setCount(this.getCount() + 1);
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Pair) {
            Pair p = (Pair)o;
            if(p.getChar().equals(getChar()))
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Pair right) {
        if(getCount() < right.getCount())
            return 1;
        else if(getCount() > right.getCount())
            return -1;
        else if(getCount() == right.getCount()) {
            return getChar().compareTo(right.getChar());
        }
        return 0;
    }

    public String getChar() {
        return c;
    }

    public void setChar(String c) {
        this.c = c;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

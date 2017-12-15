package com.adventofcode.memory;
public class Register {

    private String name;
    private int value;
    
    public Register() {
        this.name = "";
        this.value = 0;
    }
    
    public Register(String name) {
        this.name = name;
        this.value = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void increaseValue(int increase) {
        this.value += increase;
    }
    
    public void decreaseValue(int decrease) {
        this.value -= decrease;
    }
}

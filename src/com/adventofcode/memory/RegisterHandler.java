package com.adventofcode.memory;

import java.util.ArrayList;
import java.util.List;

public class RegisterHandler {
    private enum Math { INC, DEC };
    private enum Condition { LESS, LESS_OR_EQUAL, EQUAL, NOT_EQUAL, GREATER, GREATER_OR_EQUAL };
    
    private List<Register> registers;
    private int maxValue;
    
    private Condition condition;
    private Math math;
    
    public RegisterHandler() {
        registers = new ArrayList<Register>();
        maxValue = Integer.MIN_VALUE;
    }
    
    public int getMaxValueOverTime() {
        return this.maxValue;
    }
    
    public int getLargestRegister() {
        int max = Integer.MIN_VALUE;
        for(Register r : registers) {
            max = java.lang.Math.max(max, r.getValue());
        }
        return max;
    }
    
    public void parseInstructions(String instructions) {
        String[] parse = instructions.split(" ");
        String firstRegister = parse[0];
        String secondRegister = parse[4];
        
        // Create register if they don't exists
        if(getRegisterByName(firstRegister) == null) {
            createRegister(firstRegister);
        }
        if(getRegisterByName(secondRegister) == null) {
            createRegister(secondRegister);
        }
        
        setIncOrDec(parse[1]);
        setCondition(parse[5]);
        
        int conditionValue = Integer.parseInt(parse[6]);
        int incOrDecValue = Integer.parseInt(parse[2]);
        
        if(checkCondition(secondRegister, conditionValue)) {
            executeInstruction(firstRegister, incOrDecValue);
        }
    }
    
    private void executeInstruction(String firstRegister, int value) {
        Register register = getRegisterByName(firstRegister);
        incOrDecRegister(register, value);
    }
    
    private void incOrDecRegister(Register register, int value) {
        switch(this.math) {
        case DEC:
            register.decreaseValue(value);
            break;
        case INC:
            register.increaseValue(value);
            break;
        }
        this.maxValue = java.lang.Math.max(this.maxValue, register.getValue());
    }
    
    private boolean checkCondition(String secondRegister, int value) {
        int registerValue = getRegisterByName(secondRegister).getValue();
        switch(this.condition) {
        case LESS:
            if(registerValue < value)
                return true;
            break;
        case LESS_OR_EQUAL:
            if(registerValue <= value)
                return true;
            break;
        case EQUAL:
            if(registerValue == value)
                return true;
            break;
        case NOT_EQUAL:
            if(registerValue != value)
                return true;
            break;
        case GREATER:
            if(registerValue > value)
                return true;
            break;
        case GREATER_OR_EQUAL:
            if(registerValue >= value)
                return true;
            break;
        }
        return false;
    }
    
    private void setCondition(String condition) {
        switch(condition) {
        case "<":
            this.condition = Condition.LESS;
            break;
        case "<=":
            this.condition = Condition.LESS_OR_EQUAL;
            break;
        case "==":
            this.condition = Condition.EQUAL;
            break;
        case "!=":
            this.condition = Condition.NOT_EQUAL;
            break;
        case ">":
            this.condition = Condition.GREATER;
            break;
        case ">=":
            this.condition = Condition.GREATER_OR_EQUAL;
            break;
        }
    }
    
    private void setIncOrDec(String incOrDec) {
        switch(incOrDec) {
        case "inc":
            this.math = Math.INC;
            break;
        case "dec":
            this.math = Math.DEC;
            break;
        }
    }
    
    private Register createRegister(String name) {
        Register register = new Register(name);
        registers.add(register);
        return register;
    }
    
    private Register getRegisterByName(String name) {
        for(Register r : registers) {
            if(r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }
}

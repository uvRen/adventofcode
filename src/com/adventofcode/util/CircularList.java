package com.adventofcode.util;

import java.util.ArrayList;
import java.util.List;

public class CircularList {
    
    private List<String> list;
    private int length;
    private int offset;
    
    public CircularList() {
        list = new ArrayList<String>();
        length = 0;
        offset = 0;
    }
    
    public CircularList(int offset) {
        list = new ArrayList<String>();
        length = 0;
        this.offset = offset;
    }
    
    /**
     * This function makes a list of a string.
     * Each char in the string will become a item in the list.
     * @param toBeList The string that will be converted to a list
     */
    public void convertStringToList(String toBeList) {
        for(int i = 0; i < toBeList.length(); i++) {
            list.add("" + toBeList.charAt(i));
        }
        length = list.size();
    }
    
    public String getStringAtWithOffset(int position) {
        return list.get((position + offset) % length);
    }
    
    public String getStringAt(int position) {
        return list.get(position % length);
    }
}

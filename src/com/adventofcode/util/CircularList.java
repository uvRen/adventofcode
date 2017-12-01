package com.adventofcode.util;

import java.util.ArrayList;
import java.util.List;

public class CircularList {
    
    private List<String> list;
    private int length;
    
    public CircularList() {
        list = new ArrayList<String>();
        length = 0;
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
    
    public String getCharAt(int position) {
        return "";
    }
}

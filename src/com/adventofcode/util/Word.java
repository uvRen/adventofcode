package com.adventofcode.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word {
    private String word;
    private List<Pair> letters;
    
    public Word() {
        letters = new ArrayList<Pair>();
    }
    
    public Word(String word) {
        letters = new ArrayList<Pair>();
        setWord(word);
    }
    
    public String getWord() {
        return this.word;
    }
    
    public void setWord(String word) {
        this.word = word;
        calculateLetterOccurencies(word);
        Collections.sort(letters);
    }
    
    private void calculateLetterOccurencies(String word) {
        int index = -1;
        for(int i = 0; i < word.length(); i++) {
            index = getIndexOfLetter(word.charAt(i));
            // Add new letter
            if(index == -1) {
                letters.add(new Pair(word.charAt(i) + ""));
            } else {
                letters.get(index).increaseCount();
            }
        }
    }
    
    private int getIndexOfLetter(char c) {
        for(int i = 0; i < letters.size(); i++) {
            if(letters.get(i).getString().equals(c + ""))
                return i;
        }
        return -1;
    }
    
    /**
     * Letters need to be sorted to use this function
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Word) {
            Word w = (Word)o;
            if(w.letters.size() != this.letters.size()) {
                return false;
            }
            for(int i = 0; i < letters.size(); i++) {
                if(!w.letters.get(i).c.equals(this.letters.get(i).c)) {
                    return false;
                }
                if(w.letters.get(i).count != this.letters.get(i).count) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

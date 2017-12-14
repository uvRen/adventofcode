package com.adventofcode.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
    private List<String> words;
    private List<Word> wordList;
    private boolean onlyUniqueWords = true;
    
    public WordCounter() {
    }
    
    public boolean hasRowDuplicateWords(String row) {
        words = new ArrayList<String>();
        Scanner scanner = new Scanner(row);
        String word = "";
        while(scanner.hasNext()) {
            word = scanner.next();
            if(words.contains(word)) {
                scanner.close();
                return true;
            }
            words.add(word);
        }
        scanner.close();
        return false;
    }
    
    public boolean hasRowAnagrams(String row) {
        onlyUniqueWords = true;
        wordList = new ArrayList<Word>();
        Scanner scanner = new Scanner(row);
        String word = "";
        Word w = null;
        while(scanner.hasNext()) {
            word = scanner.next();
            w = new Word(word);
            if(wordList.contains(w))
                onlyUniqueWords = false;
            wordList.add(w);
        }
        scanner.close();
        return !onlyUniqueWords;
    }
}

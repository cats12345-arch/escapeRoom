package com.model;

import java.util.ArrayList;

public class CipherPuzzle extends Puzzle {
    protected int caesarCiphers;
    protected String anagram;
    protected String encodedText;

    public CipherPuzzle(String plainText, int caesarCiphers, String anagram, ArrayList<String> hint, int puzzleNum) {
        super(plainText, hint, puzzleNum, "CIPHER");
        this.caesarCiphers = caesarCiphers;
        this.anagram = anagram;
        this.encodedText = encrypt(plainText, caesarCiphers);
    }

    public int getCeaserCipher() {
        return caesarCiphers;
    }

    public String getAnagram() {
        return anagram;
    }

    private String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) ('A' + (c - 'A' + shift) % 26);
                result.append(shifted);
            } else {
                result.append(c);
            }
        }                                 //make method to print out the hints
        return result.toString(); 
    }

    public String hintString(ArrayList<String> hint) {
        String finalString = "";
        for(int i=0; i<hint.size(); i++) {
            finalString += hint.get(i);
        }
        return finalString;
    }

    

    @Override
    public void displayHint() {
        System.out.println("Cipher Puzzle:");
        System.out.println("Encoded Text: " + encodedText);
        System.out.println("Hint: The letters are shifted forward by " + caesarCiphers + ".");
        if (anagram != null && !anagram.isEmpty()) {
            System.out.println("Anagram Clue: " + anagram);
        }
        super.displayHint();
    }

    @Override
    public String toString() {
        return puzzleType + "|" + solution + "|" + caesarCiphers + "|" + anagram + "|" + encodedText + "|" + puzzleNum;
    }
}

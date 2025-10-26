package com.model;

import java.util.ArrayList;

public class CipherPuzzle extends Puzzle {
    protected int caesarCiphers;
    protected String anagram;
    protected String encodedText;
/**
 * 
 * @param plainText the original message, number ofshifts, optional hint, list of hints, puzzle number 
 * @param caesarCiphers
 * @param anagram
 * @param hint
 * @param puzzleNum
 */
    public CipherPuzzle(String plainText, int caesarCiphers, String anagram, ArrayList<String> hint, int puzzleNum) {
        super(plainText, hint, puzzleNum, "CIPHER");
        this.caesarCiphers = caesarCiphers;
        this.anagram = anagram;
        this.encodedText = encrypt(plainText, caesarCiphers);
    }
/**
 * 
 * @return the ceasar iphers shift value
 */
    public int getCeaserCipher() {
        return caesarCiphers;
    }
/**
 * 
 * @return returns anagram hint
 */
    public String getAnagram() {
        return anagram;
    }
/**
 * 
 * @param text the text getting encrypted
 * @param shift the number of letters to be shifted
 * @return the actualy cipher
 */
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
/**
 * 
 * @param hint the list of hints
 * @return combined hint string
 * 
 */
    public String hintString(ArrayList<String> hint) {
        String finalString = "";
        for(int i=0; i<hint.size(); i++) {
            finalString += hint.get(i);
        }
        return finalString;
    }

    

    /**
     * displays text and relevant hints
     */
    public void displayHint() {
        System.out.println("Cipher Puzzle:");
        System.out.println("Encoded Text: " + encodedText);
        System.out.println("Hint: The letters are shifted forward by " + caesarCiphers + ".");
        if (anagram != null && !anagram.isEmpty()) {
            System.out.println("Anagram Clue: " + anagram);
        }
        super.displayHint();
    }

    /**
     * @return string of the cipher puzzle
     */
    public String toString() {
        return puzzleType + "|" + solution + "|" + caesarCiphers + "|" + anagram + "|" + encodedText + "|" + puzzleNum;
    }
}

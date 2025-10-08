package com.model;
public class CipherPuzzle extends Puzzle {
     protected int caesarCiphers;
     protected String anagram;
     private String hint;

     public void solvePuzzle(String input) {

     }

     public void displayHint() {

     }

     public String toString() {
        return "Cipher Puzzle with cipher :" + caesarCiphers + ", anagram: " + anagram;
     }
}

package com.model;

import java.util.ArrayList;

public class CipherPuzzle extends Puzzle {
     protected int caesarCiphers;
     protected String anagram;
     private String encodedText;


     public CipherPuzzle(String plainText, int caesarCiphers, String anagram, ArrayList<String> hints, int puzzleNum) {
      super(plainText, hints, puzzleNum);
      this.caesarCiphers = caesarCiphers;
      this.anagram = anagram;
      this.encodedText = encrypt(plainText, caesarCiphers);
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
        }
        return result.toString();
    }

    public boolean attempt(string input) {
      if (input == null || input.isEmpty()) {
         System.out.println("Enter a guess to decode the cipher.");
         return false;
      }

      if (input.equalsIgnoreCase(solution)) {
         solved = true;
         System.out.println("Thats correct! you solved the cipher.");
         return true;
      } else {
         System.out.println("Incorrect. Try again or use a hint.");
         return false;
      }
    }

    public void displayHint() {
      System.out.println("Cipher Puzzle: ");
      System.out.println("Encoded Text: + encodedText");
      System.out.println("Hint: The letters are shifted forward by " + caesarCiphers + ".");
      if (anagram != null && !anagram.isEmpty()) {
         System.out.println("Extra Clue (anagram): " + anagram);
      }
      super.displayHint();
    }

    public String toString() {
      return "Cipher Puzzle (Shift " + caesarCiphers + "):" + encodedText + (anagram != null ? ", Anagram: " + anagram : "");
    } 
}

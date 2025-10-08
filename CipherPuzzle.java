public class CipherPuzzle extends Puzzle {
     protected int caesarCiphers = 4;
     protected String anagram;
     private String hint = " The letters are shifted forward by " + caesarCiphers + ".";


     private String encrypt(String text, int shift) {
      StringBuilder result = new StringBuilder();
      for (char c : text.toUpperCase().toCharArray()) {
         if (Character.isLetter(c)) {
            char shifted = (char) ((c- 'A' + shift)% 26 + 'A');
            result.append(shifted);
         } else {
            result.append(c);
         }

      }
      return result.toString();
     }

     public void solvePuzzle(String input) {
      if (input == null) return;
      if (input.equalsIgnoreCase(solution)) {
         this.solved = true;
         System.out.println("Thats Correct! You solved the cipher.");
      } else {
         System.out.println("Incorrect");
      }

     }

     public void displayHint() {
      System.out.println("Hint: " + hint);
     }

     public String toString() {
        return "Cipher Puzzle with cipher :" + caesarCiphers + ", anagram: " + anagram;
     }
}

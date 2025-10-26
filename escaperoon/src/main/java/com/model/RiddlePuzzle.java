package com.model;

import java.util.ArrayList;

public class RiddlePuzzle extends Puzzle {
    protected String riddle;
    
/**
 * 
 * @param riddle riddle question , correct answer, list the hints, and puzzlenumber
 * @param answer
 * @param hint
 * @param puzzleNum
 */
    public RiddlePuzzle(String riddle, String answer, ArrayList<String> hint, int puzzleNum) {
        super(answer, hint, puzzleNum, "RIDDLE");
        this.riddle = riddle;
    }
/**
 * default constructor
 */
    public RiddlePuzzle() {
        super();
        this.riddle = "";
        this.puzzleType = "RIDDLE";
    }
/**
 * 
 * @return the string of the riddle
 */
    public String getRiddle() {
        return riddle;
    }

   /**
    * @param input for the answer
    * @return true or false based on answer
    */
    public boolean attempt(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Enter an answer to solve the riddle.");
            return false;
        }

        if (input.equalsIgnoreCase(solution)) {

            System.out.println("Correct! You solved the riddle.");
            return true;
        } else {
            System.out.println("Incorrect. Try again or use a hint.");
            return false;
        }
    }

   /**
    * hints for puzzle
    */
    public void displayHint() {
        System.out.println("Riddle: " + riddle);
        super.displayHint();
    }

    /**
     * string of the puzzle
     */
    public String toString() {
        return puzzleType + "|" + riddle + "|" + solution + "|" + puzzleNum + "|" + hintString(hint);
    }
/**
 * 
 * @param hint the list of hints
 * @return hint string
 */
    public String hintString(ArrayList<String> hint) {
        String finalString = "";
        for(int i=0; i<hint.size(); i++) {
            finalString += hint.get(i);
        }
        return finalString;
    }
/**
 * 
 * @return list of possible riddles to be selected
 */
    public static ArrayList<RiddlePuzzle> loadDefaultRiddles() {
        ArrayList<RiddlePuzzle> riddles = new ArrayList<>();

        riddles.add(new RiddlePuzzle(
                "I grow in fields and feed the land; trade me well to lend a hand.",
                "WHEAT",
                new ArrayList<>(java.util.List.of("A golden resource from the fields.")),
                1
        ));

        riddles.add(new RiddlePuzzle(
                "From mountains high, I shine and gleam; build your cities with my beam.",
                "ORE",
                new ArrayList<>(java.util.List.of("A mined rocky resource.")),
                2
        ));

        riddles.add(new RiddlePuzzle(
                "Lay me down to reach new ground; I'm strong and sound, made of wood and brick to expand real quick!",
                "ROAD",
                new ArrayList<>(java.util.List.of("Used to connect settlements.")),
                3
        ));

        riddles.add(new RiddlePuzzle(
                "Trade and build, expand your might; gather resources to win the fight.",
                "CATAN",
                new ArrayList<>(java.util.List.of("The name of the island itself.")),
                4
        ));

        return riddles;
    }
}

package com.model;

import java.util.ArrayList;

public class RiddlePuzzle extends Puzzle {
    protected String riddle;

    public RiddlePuzzle(String riddle, String answer, ArrayList<String> hint, int puzzleNum) {
        super(answer, hint, puzzleNum, "RIDDLE");
        this.riddle = riddle;
    }

    public RiddlePuzzle() {
        super();
        this.riddle = "";
        this.puzzleType = "RIDDLE";
    }

    @Override
    public boolean attempt(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Enter an answer to solve the riddle.");
            return false;
        }

        if (input.equalsIgnoreCase(solution)) {
            solved = true;
            System.out.println("Correct! You solved the riddle.");
            return true;
        } else {
            System.out.println("Incorrect. Try again or use a hint.");
            return false;
        }
    }

    @Override
    public void displayHint() {
        System.out.println("Riddle: " + riddle);
        super.displayHint();
    }

    @Override
    public String toString() {
        return puzzleType + "|" + riddle + "|" + solution + "|" + puzzleNum + "|" + solved + "|" + String.join(",", hint);
    }

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
                new ArrayList<>(java.util.List.of("A mined resource.")),
                2
        ));

        riddles.add(new RiddlePuzzle(
                "Lay me down to reach new ground; I'm made of wood, strong and sound.",
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

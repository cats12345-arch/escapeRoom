public class RiddlePuzzle extends Puzzle {
    protected String riddle;
    private String hint;
    private String answer;

    public RiddlePuzzle(String riddle, String answer, String hint) {
        this.riddle = riddle;
        this.answer = answer.toUpperCase(); 
        this.hint = hint;
    }

    public boolean solvePuzzle(String input) {
if (input == null) return false;
        switch (answer) {
            case "WHEAT":
                return input.equalsIgnoreCase("WHEAT");
        }
        return input.equalsIgnoreCase(answer);
    }

    public void  displayHint() {
        System.out.println("Hint: " + hint);
    }

    public String toString() {
        return "Riddle Puzzle: " + riddle;
    }
}

import java.util.ArrayList;

public abstract class Puzzle {
    protected String solution;
    protected ArrayList <Hint> hint;
    protected int puzzleNum;
    protected boolean solved;

    public void grabItem() {

    }

    public void lookAtItem() {

    }

    public void addItem() {

    }

    public void attempt(String input) {

    }

    public void showHint() {

    }

    public void reset() {

    }

    public boolean isSolved() {
        return solved;
    }

    public void displayHint() {

    }  
}

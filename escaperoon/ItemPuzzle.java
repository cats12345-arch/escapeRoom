public class ItemPuzzle extends Puzzle {
    protected Item item;
    private String hint;

    public boolean playerHasItem(Item item) {
        return false;
    }

    public void solvePuzzle(String input) {

    }

    public void displayHint() {

    }

    public String toString() {
        return "Item Puzzle with item:"  + (item != null ? item.toString() : "none");
    }

}

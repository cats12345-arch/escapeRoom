package escaperoon;

import java.util.ArrayList;

public static class Room 
{
    protected String roomName;
    protected String type;
    protected boolean solved;
    protected Arraylist<Puzzle> puzzles;
    protected ArrayList<Item> inventory;

     public Room()
 {
    this.roomName = "Unnamed";
    this.type = "Normal";
    this.solved = false;
    this.puzzles = new ArrayList<>();
    this.inventory = new ArrayList<>();

 }

 public void reset()
 {
    this.solved = false;
    for(Puzzle p : puzzles)
    {
        p.reset();
    }
 }

 public boolean isSolved()
 {
    for(Puzzle p: puzzles)
    {
        if(!p.isSolved())
        {
            return false;
        }
    }
    return solved;
 }

 public Item getItem(Player player)
 {
    if(!inventory.isEmpty())
    {
        Item item = inventory.remove(0);
        player.giveItem(item);
        return item;
    }
    return 0;
 }

 public void exploreRoom()
 {
   
 }
    
 public void startPuzzle()
 {

 }

 public String toString()
 {
    return roomName + type + solved + puzzles.toString() + inventory.toString(); 
 }

 
}
 

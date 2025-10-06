package escaperoon;

import java.util.ArrayList;

public class Room 
{
    private String roomName;
    private String type;
    private boolean solved;
    private Arraylist<Puzzle> puzzles;
    private ArrayList<Item> inventory;

     public Room()
 {
    this.roomName = "";
    this.type = "";
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

 }

 public Item getItem(Player player)
 {

 }

 public void exploreRoom()
 {

 }
    
 public void startPuzzle()
 {

 }

 
}
 

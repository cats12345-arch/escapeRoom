package com.model;

import java.util.ArrayList;

public class RoomList 
{
    /**
     * The single instanse
     */
    private static RoomList roomList;


    /**
     * List of all rooms 
     */
    private ArrayList<Room> rooms;

    /**
     * Private constructor. Loads the rooms using DataLoader
     */
    private RoomList()
    {
        rooms = DataLoader.getRooms();
    }

    /**
     * Returns the single instance of RoomList.
     * Creates it if it doesn't exist.
     *
     * @return the RoomList instance
     */
    public static RoomList getInstance()
    {
        if(roomList == null)
        {
            roomList = new RoomList();
        }
        return roomList;
    }

    /**
     * Gets the list of all rooms.
     *
     * @return list of rooms
     */
    public ArrayList<Room> getRoomList() {
        return rooms;
    }

    /**
     * Finds a room by name (case-insensitive).
     *
     * @param roomName the name of the room
     * @return the matching room, or null if not found
     */
    public Room getRoom(String roomName)
    {
        for (Room room : rooms)
        {
            if(room.roomName.equalsIgnoreCase(roomName))
            {
                return room;
            }
        }
        return null;
    }

<<<<<<< HEAD
    /**
     * Saves all room data using {@link DataWriter#saveRooms()}.
     */
=======
    public Room getRoom(int num) {
        if(num > rooms.size()) {
            return null;
        }
        return rooms.get(num);
    }

>>>>>>> 69f4a285f71349914a29647bfcb21e2be6206e07
    public void saveRoom()
    {
        DataWriter.saveRooms();
    }

    /**
     * Starts a new game and resets all rooms.
     */
    public void newStart()
    {
        System.out.println("Starting new game...");
    }
        

    /**
     * Returns a string representation of the room list.
     *
     * @return string of all rooms
     */
    @Override
    public String toString()
    {
        return roomList + rooms.toString();
    }
}
package com.model;

import java.util.ArrayList;

public class RoomList 
{
    private static RoomList roomList;

    private ArrayList<Room> rooms;

    private RoomList()
    {
        rooms = DataLoader.getRooms();
    }

    public static RoomList getInstance()
    {
        if(roomList == null)
        {
            roomList = new RoomList();
        }
        return roomList;
    }

    public ArrayList<Room> getRoomList() {
        return rooms;
    }

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

    public Room getRoom(int num) {
        if(num > rooms.size()) {
            return null;
        }
        return rooms.get(num);
    }

    public void saveRoom()
    {
        DataWriter.saveRooms();
    }

    public void newStart()
    {
        System.out.println("Starting new game...");
        for (Room room : rooms)
        {
            room.reset();
        }
    }

    public String toString()
    {
        return roomList + rooms.toString();
    }


}

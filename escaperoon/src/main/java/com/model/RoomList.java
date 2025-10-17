package com.model;

import java.util.ArrayList;

public class RoomList {

    private static RoomList roomList;

    //Collection of rooms 
    private ArrayList<Room> rooms;

    //private constructor 
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

    public Room getRoom(String roomName)
    {
        return null;
    }

    public void newRoom()
    {
        System.out.println("");
    }

    public void newStart()
    {
        
    }
    
}

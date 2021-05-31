package ass3.mygame;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * The Room class contains information about the room. 
 * It has name, description, lock status, list of items. 
 * Please see {@link RoomCreation} for list of rooms. 
 * @author  Cam Chuong Lac, Margi Patel
 * @version 1
 */

public class Room 
{
    private String description;
    private String name;
    private boolean isLocked;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> roomItem;
//    private HashMap<Room, Item> roomHashMapItem;

    /**
     * Create a room described "description".Initially, it has
 no exits."description" is something like "a kitchen" or
 "an open court yard".
     * @param name The name of the room.
     * @param description The room's description.
     * @param isLocked the lock status of the room.
     */
    public Room(String name, String description, boolean isLocked) 
    {
        this.description = description;
        this.name = name;
        this.isLocked = isLocked;
        exits = new HashMap<>();
        roomItem = new ArrayList();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Method to get description of the item.
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are at the " + name + ".\n" + description + ".\n" + getExitString() + ".\n" + getAllItems();
    }

    /**
     * Method to get all items name using {@link #listOfItems() listOfItems()}
     * @return A string contains all items in room
     */
    public String getAllItems(){

        return "You have some " + listOfItems();

    }

    /**
     * Method to list all items name
     * @return A string which contains all items name
     */
    private String listOfItems(){

        String returnString = "items:";
        for(Item item : roomItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Method getRoomItem
     *
     * @param stringItem taken from the command which was converted into a String
     * @return Item class according to the input String
     */
    public Item getRoomItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: roomItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }

    /**
     * Method to add item into room
     * @param item The {@link Item} that needs to be added
     */
    public void addItemInRoom(Item item){
        roomItem.add(item);
    }

    /**
     * Method to remove item from room
     * @param item The {@link Item} that needs to be removed
     */
    public void removeItemInRoom(Item item){
        if(roomItem.size() > 0){
            roomItem.remove(item);
        }
    }

//    public void addHashMapItemInRoom(Room room, Item item){
//        roomHashMapItem.put(room, item);
//    }

    /**
     * Method getLockedStatus
     * @return True if the room is locked, otherwise false
     */
    public boolean getLockedStatus(){
        return isLocked;
    }

    /**
     * Method to set the value for lock status
     * @param newStatus The new status for the room, true is locked and false is unlocked
     */
    public void setLockedStatus(boolean newStatus){
        isLocked = newStatus;
    }
    
    /**
     * Method to get name of the room
     * @return A string which represents the name of room
     */
    public String getName(){
        return name;
    }

    
}


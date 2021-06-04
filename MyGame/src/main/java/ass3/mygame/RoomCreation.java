package ass3.mygame;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * RoomCreation class stores list of rooms in game. 
 * Each room links to at least one other room in a particular direction. 
 * @author Cam Chuong Lac, Margi Patel
 * @version 5.0
 */
public class RoomCreation {

    private ArrayList<Room> allRoomInGame = new ArrayList();

    private ItemCreation itemCreation;

    /**
     * Constructor of RoomCreation, initialise the ArrayList of item and 
     * run {@link #createRooms() createRooms()}.
     */
    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
    
    /**
     * Method to create rooms in game.
     * There are four rooms: castle, kitchen, frontGate, treasureRoom. 
     * Each room links to at least one other room.
     * Each room has different items available to take.
     * @see Room
     */
    private void createRooms() {

        Room castle, kitchen, frontGate, treasureRoom;

        //Initialise the rooms
        castle = new Room("castle", "The wall is high up to the sky", false);
        kitchen = new Room("kitchen", "The kitchen is big", false);
        frontGate = new Room("frontGate", "There is a giant ogre", true);
        treasureRoom = new Room("treasureRoom", "There are lots of treasures", false);

        //Set exits for rooms
        castle.setExit("east", kitchen);
        castle.setExit("south", frontGate);
        frontGate.setExit("north", castle);
        kitchen.setExit("west", castle);
        castle.setExit("west", treasureRoom);
        treasureRoom.setExit("east", castle);

        //Add items into rooms
        castle.addItemInRoom(itemCreation.getItem("excaliburSword"));
        frontGate.addItemInRoom(itemCreation.getItem("key"));
        kitchen.addItemInRoom(itemCreation.getItem("frontGateKey"));
        treasureRoom.addItemInRoom(itemCreation.getItem("armor"));

        //Add rooms into ArrayList
        allRoomInGame.add(castle);
        allRoomInGame.add(frontGate);
        allRoomInGame.add(kitchen);
        allRoomInGame.add(treasureRoom);
    }

    /**
     * Method to get room object from the room list using room name.
     * @param stringRoom The name of the room that needs to be returned.
     * @return the room that has been requested.
     */
    public Room getRoom(String stringRoom) {
        Room roomToReturn = null;
        for (Room room : allRoomInGame) {
            if (room.getName().contains(stringRoom)) {
                roomToReturn = room;
            }
        }
        return roomToReturn;
    }

}

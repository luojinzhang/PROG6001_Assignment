package ass3.mygame;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * RoomCreation class contains list of rooms in game. 
 * Each room links to another in a direction. 
 * @author Cam Chuong Lac, Margi Patel
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
     * Each room links to another by directions.
     * Each room has different items.
     * @see Room
     */
    private void createRooms() {

        Room castle, kitchen, frontGate, treasureRoom;

        castle = new Room("castle", "The wall is high up to the sky", false);
        kitchen = new Room("kitchen", "The kitchen door has a shape of a heart", false);
        frontGate = new Room("frontGate", "There is a giant ogre", true);
        treasureRoom = new Room("treasureRoom", "There are lots of treasures", false);

        castle.setExit("east", kitchen);
        castle.setExit("south", frontGate);
        frontGate.setExit("north", castle);
        kitchen.setExit("west", castle);
        castle.setExit("west", treasureRoom);
        treasureRoom.setExit("east", castle);
        

        castle.addItemInRoom(itemCreation.getItem("excaliburSword"));
        castle.addItemInRoom(itemCreation.getItem("key"));
        kitchen.addItemInRoom(itemCreation.getItem("frontGateKey"));
        treasureRoom.addItemInRoom(itemCreation.getItem("armor"));

        allRoomInGame.add(castle);
        allRoomInGame.add(frontGate);
        allRoomInGame.add(kitchen);
        allRoomInGame.add(treasureRoom);
    }

    /**
     * Method to get room
     * @param stringRoom The name of the room that needs to find
     * @return the room that has the same name
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

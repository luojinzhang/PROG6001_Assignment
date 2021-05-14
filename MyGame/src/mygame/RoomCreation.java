package mygame;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RoomCreation {

    private ArrayList<Room> allRoomInGame = new ArrayList();

    private ItemCreation itemCreation;

    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
    
    
    private void createRooms() {

        Room castle, kitchen, frontGate, treasureRoom;

        castle = new Room("castle", "You are at the castle", false);
        kitchen = new Room("kitchen", "The kitchen door has a shape of a heart", false);
        frontGate = new Room("frontGate", "There is a giant ogre", true);
        treasureRoom = new Room("treasureRoom", "There are lots of treasures "
                + "inside but it is locked", true);

        castle.setExit("east", kitchen);
        castle.setExit("south", frontGate);
        frontGate.setExit("north", castle);
        castle.setExit("west", treasureRoom);
        treasureRoom.setExit("east", castle);
        

        castle.addItemInRoom(itemCreation.getItem("excaliburSword"));
        castle.addItemInRoom(itemCreation.getItem("key"));
        kitchen.addItemInRoom(itemCreation.getItem("frontGateKey"));

        allRoomInGame.add(castle);
        allRoomInGame.add(frontGate);
        allRoomInGame.add(kitchen);
        allRoomInGame.add(treasureRoom);
    }

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

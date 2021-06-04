/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3.mygame;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Game class contains the logic of the game. 
 * Please see {@link CommandWords} for list of valid commands. 
 * Please see {@link ItemCreation} for list of items. 
 * Please see {@link RoomCreation} for list of rooms. 
 * @author Cam Chuong Lac, Margi Patel
 * @version 5.0
 */

public class Game {

    private Parser parser;
    private Player player;
    private Room currentRoom;
    private RoomCreation rooms;

    private HashMap<Item, Room> roomItem;

    private HashMap<Item, Room> roomKey;

    private int timeCounter; // to count the steps

    /**
     * Constructor of Game class. 
     * Create the game and initialise its internal map.
     */
    public Game() {
        long timeStart = System.currentTimeMillis(); // use the real time
        timeCounter = 50;
        parser = new Parser();
        player = new Player();
        rooms = new RoomCreation();
        currentRoom = rooms.getRoom("castle");  // start game outside
        //System.out.println(createRoom.getcurrentRoom().getName());
    }
    
    /**
     * Method to get the current room
     * @return the current room
     * @see Room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    
    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            long currentTime = System.currentTimeMillis();
            Command command = parser.getCommand();
            // count the delta (currentTome - startTime)            
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("You are the hero.");
        System.out.println("You need to find the items to fight the battle.");
//        System.out.println("include some necessary information (e.g. time limit)");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("inventory")) {
            printInventory(); // printVeggies
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("take")) {
            takeItem(command);
        } else if (commandWord.equals("drop")) {
            dropItem(command);
        } 
//        else if (commandWord.equals("use")) {
//            //useItem(command);
//        } else if (commandWord.equals("inspect")) {
//            //lookItem(command);
//        } 
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord.equals("unlock")) {
           unlockRoom(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    
    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        System.out.println("");

        System.out.println("Your command words are:");
        parser.showCommands();
        
        // implement random Hints -> massive bonus points 
        System.out.println("you can go to another room using go command + direction");
        System.out.println("you can take items using take command");
        System.out.println("you can drop items using drop command");
        System.out.println("you can unlock the door using the unlock command");
        System.out.println("you can check inventory using the inventory command");
//        System.out.println("you need to clear the ogre before you can open the kitchen door");
        System.out.println("you can quit the game using quit command");
        System.out.println("you can check the instruction again using help command");
        System.out.println();
    }

    /**
     * Print all items in inventory of player
     * @see Player
     */
    private void printInventory() {
        System.out.println(player.printAllInventory());
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     * @param command Instance of Command class which is a string provided by user as input
     * @see Command
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            if (currentRoom.getLockedStatus() == true) { // the door is locked
                System.out.println("The door is locked, you need to find a way to open it");
                System.out.println(currentRoom.getLongDescription());
            } else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                //System.out.println(currentRoom.printAllRoomItems());
                // increment the timeCounter
            }
        }
    }
    /**
     * The take item function. 
     * Try to take the item, if item exists, move it into inventory else print error message.
     * @param command Instance of Command class which is a string provided by user as input
     * @see Command
     */
    private void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't take nothing, no?");
        } else {
            // Do the transaction here
            currentRoom.removeItemInRoom(currentItem);
            player.addItemInventory(currentItem);

            //roomItem.remove(currentItem);
            //addItemInventory(currentItem);
            //System.out.println(currentRoom.getLongDescription());
        }
    }

    /**
     * The drop item function. 
     * Try to drop an item from inventory, if item exist it will move the item back to the current room, else print error message.
     * @param command Instance of Command class which is a string provided by user as input
     * @see Command
     */
    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = player.getPlayerItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't take nothing, no?");
        } else {
            // Do the transaction here
            player.removeItemInventory(currentItem);
            currentRoom.addItemInRoom(currentItem);

            //removeItemInventory(currentItem);
            //roomItem.put(currentItem, currentRoom);
            //System.out.println(currentRoom.getLongDescription());
        }
    }

//    private void useItem(Command command) // use key
//    {
//        if (!command.hasSecondWord()) {
//            // if there is no second word, we don't know where to go...
//            System.out.println("Take what?");
//            return;
//        }
//
//        String itemFromCommand = command.getSecondWord();
//        Item currentItem = currentRoom.getRoomItem(itemFromCommand);
//
//        if (currentItem == null) {
//            System.out.println("You can't use nothing, no?");
//        } else {
//            // you want make sure that the currentRoom is the room where you want to open the door (before the nextdoor).
//            // you want to make sure the currentItem matches the key to open the next door.
//
//            //if(currentRoom.getName().equals("castle") && currentItem.getName().equals("key")){
//            //.setLockedStatus(false);
//            System.out.println("You just used the " + currentItem.getName());
//
//            //if(currentRoom.getName().equals("frontYard") && currentItem.getName().equals("item1")){
//            //frontGate.setLockedStatus(false);
//            // if(currentRoom.getName().equals("castle")){
//            // //currentRoom.checkRoom("castle");
//            // roomKey.get(currentItem).setLockedStatus(false);
//            // }
//            System.out.println("You cannot use this item here");
//
//        }
//
//    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
    /**
     * The unlock room function. Try to unlock the room, if the room does not exist or is not locked, print error message. 
     * Else, check if player has the key, if yes, unlock the room, else, return the message.
     * @param command Instance of Command class which is a string provided by user as input
     * @see Command
     */
    private void unlockRoom(Command command)
    {
        if (!command.hasSecondWord()) {
            System.out.println("Unlock what ?");
            return;
        }
        
        String roomFromSecondWord = command.getSecondWord();
        String curRoomName = currentRoom.getName();
        
        //Check if currentRoom is locked.
        if (!currentRoom.getLockedStatus())
        {
            System.out.println("The " + curRoomName + " is not locked");
        }
        //Check if the command is to unlock the correct room.
        else if (curRoomName.equals(roomFromSecondWord))
        {
            //Check if player has the key
            if (player.getPlayerItem("key") != null)
            {
                //Unlock the room
                currentRoom.setLockedStatus(false);
                System.out.println("The " + curRoomName + " is unlocked");
            }
            else
            {
                System.out.println("You need the key to unlock");
            }
           
        }
    }

}


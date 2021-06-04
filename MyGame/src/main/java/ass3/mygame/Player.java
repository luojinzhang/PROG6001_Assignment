package ass3.mygame;


import java.util.ArrayList;


/**
 * The Player class stores information about the player, including items in inventory.
 * @author Cam Chuong Lac, Margi Patel
 * @version 5.0
 * @see Item
 */
public class Player
{
    
    private ArrayList<Item> playerItem;
    /**
     * Constructor of Player, initialise ArrayList of playerItem
     * @see ArrayList
     */
    public Player()
    {
        playerItem = new ArrayList();
    }
    
    /**
     * Add an item to player's inventory
     * @param item the {@link Item} that needs to be added to playerItem array
     */
    public void addItemInventory(Item item){
        playerItem.add(item);
        System.out.println(item.getName() + " was taken. ");
        System.out.println(item.getDescription());
    }
    
    /**
     * Remove an item from player's inventory
     * @param item the {@link Item} that needs to be removed from playerItem array (if exist)
     */
    public void removeItemInventory(Item item){
        playerItem.remove(item);
        System.out.println(item.getName() + " was removed from your inventory");
    }
    
    /**
     * The method to get item from player's inventory.
     * @param stringItem the name of the item that need to be returned.
     * @return the item that has been requested.
     */
    public Item getPlayerItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: playerItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
    
    /**
     * The method to print all inventory items
     * @return a string of all items name.
     */
    public String printAllInventory(){

        String returnString = "Items:";
        for(Item item : playerItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    
}

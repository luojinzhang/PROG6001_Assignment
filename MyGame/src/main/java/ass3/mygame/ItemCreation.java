package ass3.mygame;

import java.util.ArrayList;


/**
 * The ItemCreation class uses to create all items in game 
 * and contains them in an ArrayList of Item
 * @author Cam Chuong, Margi Patel
 * @version 1.0
 * @see ArrayList
 */
public class ItemCreation
{
    
    private ArrayList<Item> allItemsInGame;
    /**
     * Constructor of ItemCreation, 
     * initialize the ArrayList allItemsInGame 
     * and run method {@link #createItems() createItems}
     */
    public ItemCreation()
    {       
        allItemsInGame = new ArrayList();
        createItems();
    }
    
    /**
     * Method to create items: excaliburSword, key, frontGateKey, armor. 
     * All items are added into ArrayList allItemsInGame.
     * @see Item
     */
    public void createItems(){
        
        Item item1, item2, excaliburSword, key, frontGateKey, armor;
        
        
        excaliburSword = new Item("excaliburSword", "The legendary Excalibur", 100);
        key = new Item("key", "It has a shape of a heart", 100);
        frontGateKey = new Item("frontGateKey", "To open the front gate door", 100);
        armor = new Item("armor","The armor made by finest material", 0);
        
        allItemsInGame.add(excaliburSword);
        allItemsInGame.add(key);
        allItemsInGame.add(frontGateKey);
        allItemsInGame.add(armor);
    }
   
    /**
     * Method to get item
     * @param stringItem Name of the item that needs to find
     * @return the item
     * @see Item
     */
    public Item getItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: allItemsInGame){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
  
    
}

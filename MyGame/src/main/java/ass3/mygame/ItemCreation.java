package ass3.mygame;

import java.util.ArrayList;


/**
 * Write a description of class ItemCreation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ItemCreation
{
    
    private ArrayList<Item> allItemsInGame;
    
    public ItemCreation()
    {       
        allItemsInGame = new ArrayList();
        createItems();
    }
    
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

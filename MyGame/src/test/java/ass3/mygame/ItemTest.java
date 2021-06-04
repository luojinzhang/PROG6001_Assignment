/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3.mygame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ItemTest class to test Item class.
 * @author  Cam Chuong Lac, Margi Patel
 * @version 5.0
 */
public class ItemTest {
    Item item;
    
    public ItemTest() {
        item = new Item("gun","this is a gun", 0);
    }
    
    /**
     * Test case for armor logic.
     */
    @Test
    public void testArmor() {
        // Create the armor as expected result.
        String expResult = (new Item("armor","The armor made by finest material", 0)).getName();
        
        // Create an instance of ItemCreation.
        ItemCreation list = new ItemCreation();
        
        // Get the name of the armor from item list.
        String result = list.getItem("armor").getName();
        
        // Compare the result with expected result
        assertEquals(expResult, result);
    }

}

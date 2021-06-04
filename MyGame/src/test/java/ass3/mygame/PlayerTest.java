/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3.mygame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PlayerTest class to test Player class.
 * @author Cam Chuong Lac, Margi Patel
 * @version 5.0
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addItemInventory method, of class Player. 
     
     */
    @Test
    public void testAddItemInventory() {
        System.out.println("addItemInventory");
        
        //Create an instance of item and player.
        Item testItem = new Item ("testItem", "This is a test item", 10);
        Player player = new Player();
        
        //Use addItemInventory method to add the testItem into player inventory.
        player.addItemInventory(testItem);
        
        //Compare the test item with the item from player's inventory.
        assertEquals(testItem, player.getPlayerItem("testItem"));
    }
}

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
 * Game test class to test Game class.
 * @author  Cam Chuong Lac, Margi Patel
 * @version 5.0
 */
public class GameTest {
    
    public GameTest() {
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
     * Test treasure room logic. 
     */
    @Test
    public void testGoToTreasureRoom() {
        System.out.println("testGoToTreasureRoom");
        String expResult = "treasureRoom";
        
        //Create a command to go west. 
        Command command = new Command("go", "west");
        
        //Create game instance.
        Game instance = new Game();
        
        //Run process command to proceed the game.
        instance.processCommand(command);
        
        //Get the name of the current room.
        String result = instance.getCurrentRoom().getName();
        
        //Compare the result with expected result.
        assertEquals(expResult, result);
    }
    
    /**
     * Test unlock room logic.
     */
    @Test
    public void testUnlockRoom()
    {
        System.out.println("testUnlockRoom");
        var expResult = false;
       
         //Create game instance.
        Game instance = new Game();
        
        //Create the command take key.
        var takeKeyCommand = new Command("take", "key");
       
        //Create the command go south.
        var goSouthCommand = new Command("go", "south");
        
        //Create the command unlock frontGate.
        var unlockCommand = new Command("unlock", "frontGate");
        
        //Run processCommand to proceed the game.
        instance.processCommand(takeKeyCommand);
        instance.processCommand(goSouthCommand);
        instance.processCommand(unlockCommand);
        
        //Get the lock status of the current room.
        var result = instance.getCurrentRoom().getLockedStatus();
        
        //Compare the result with expected result.
        assertEquals(expResult, result);
    }
}

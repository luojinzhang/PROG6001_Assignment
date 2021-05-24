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
 *
 * @author USER
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
     * Test of getCurrentRoom method, of class Game.
     */
//    @Test
//    public void testGetCurrentRoom() {
//        System.out.println("getCurrentRoom");
//        Game instance = new Game();
//        String expResult = "castle";
//        Room result = instance.getCurrentRoom();
//        assertEquals(expResult, result.getName());
//    }

    /**
     * Test of play method, of class Game.
     */
  //  @Test
 //   public void testPlay() {
//        System.out.println("play");
//        Game instance = new Game();
//        instance.play();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
 //   }

    /**
     * Test treasure room logic
     */
    @Test
    public void testGoToTreasureRoom() {
        System.out.println("testGoToTreasureRoom");
        Command command = new Command("go", "west");
        Game instance = new Game();
        String expResult = "treasureRoom";
        instance.processCommand(command);
        String result = instance.getCurrentRoom().getName();
        assertEquals(expResult,result);
    }
    
    /**
     * Test unlock room logic
     */
    @Test
    public void testUnlockRoom()
    {
        System.out.println("testUnlockRoom");
        
        Game instance = new Game();
        
        var takeKeyCommand = new Command("take", "key");
        instance.processCommand(takeKeyCommand);
        var goSouthCommand = new Command("go", "south");
        instance.processCommand(goSouthCommand);
        var unlockCommand = new Command("unlock", "frontGate");
        instance.processCommand(unlockCommand);
        
        var result = instance.getCurrentRoom().getLockedStatus();
        var expResult = false;
        
        assertEquals(expResult,result);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3.mygame;

import java.util.HashSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * RoomTest class to test Room class.
 * @author Cam Chuong Lac, Margi Patel
 * @version 5.0
 */
public class RoomTest {
    
    public RoomTest() {
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
     * Test of setExit method, of class Room.
     */
    @Test
    public void testSetExit() {
        System.out.println("setExit");
        String direction = "north";
        
        //Create a room and a neighbor room.
        Room testRoom = new Room("testRoom", "This is a test room", false);
        Room neighbor = new Room("neighborRoom", "This is a neighbor room", false);
     
        //Set exit of the testRoom to the neighborRoom in north direction.
        testRoom.setExit(direction, neighbor);
        
        //Compare the neighbor room with the room that is in the north of testRoom.
        assertEquals(neighbor, testRoom.getExit("north"));
    }
}

package Doors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Clicker class.
 * 
 * @author Nate Axt
 * @version 2015.09.25
 */
public class ClickerTest {
    private Clicker click;
    
    /**
     * Sets up the objects for tests.
     */
    @Before
    public void setUp() {
        click = new Clicker();
    }
    
    /**
     * Checks the image.
     */
    @Test
    public void testImage() {
        //Do not know how to test an image at this time.
    }

    /**
     * Checks the reward from the clicker.
     */
    @Test
    public void testReward() {        
        Door.setCurrentDoor("red");
        Clicker.giveReward();
        assertTrue(Clicker.getReward() >= 1 && Clicker.getReward() < 2.98);
        
        Door.setCurrentDoor("blue");
        Clicker.giveReward();
        assertTrue(Clicker.getReward() >= 3 && Clicker.getReward() < 4.98);
        
        Door.setCurrentDoor("green");
        Clicker.giveReward();
        assertTrue(Clicker.getReward() >= 6 && Clicker.getReward() < 7.98);
    }
    
    /**
     * Checks if the number of clicks are collected.
     */
    @Test
    public void testSetClicks() {
        Clicker.setClicks();
        assertEquals(99, Clicker.getClicks());
        
        for (int i = 0; i < 100; i++) {
            Clicker.setClicks();
        }
        assertEquals(0, Clicker.getClicks());
        Clicker.refresh();
    }
    
    /**
     * Checks if the refresh method resets the clicks to 100.
     */
    @Test
    public void testRefresh() {
        Clicker.setClicks();
        Clicker.refresh();
        assertEquals(100, Clicker.getClicks());
    }
    
    /**
     * Checks if the proper reward string is returned.
     */
    @Test
    public void testRewardFormat() {
        click.setReward(1.11);
        assertEquals("1.11", Clicker.getRewardString());
    }
}
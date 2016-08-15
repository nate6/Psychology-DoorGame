package Doors;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.Test;

public class StartTest {
    
    /**
     * Tests the Start class.
     */
    @Test
    public void testStart() {
        Start start = new Start();
        assertTrue(start.getTitle().equals("Instructions"));
        assertFalse(start.isResizable());
        assertEquals(2, start.getDefaultCloseOperation());
        Dimension dim = new Dimension(800, 570);
        assertEquals(dim, start.getSize());
    }

}

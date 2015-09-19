package Doors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * The Green Door for the Door Game.
 * 
 * @author Nate Axt
 * @version 9/9/2015
 */
public class DoorGreen extends Door{
    private static final long serialVersionUID = 1L;
    private String door1;
    private String door2;
    private BufferedImage image1;
    private BufferedImage image2;
    
    /**
     * Sets up the Green Door.
     */
    public DoorGreen() {
        door1 = getDoor1();
        door2 = getDoor2();
        image1 = getImage1();
        image2 = getImage2();
    }

    /**
     * Matches the image to the door.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (door1.equals("green")) {
            scale(image1);
            g.drawImage(image1, 0, 0, null);
        }
        if (door2.equals("green")) {
            scale(image2);
            g.drawImage(image2, 0, 0, null);
        }
    }
}
package Doors;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * The Doors for the Door Game.
 * 
 * @author Nate Axt
 * @version 9/9/2015
 */
public class Door extends JButton {
    private static final long serialVersionUID = 1L;
    private static String door1 = "red";
    private static String door2 = "blue";
    private static String currentDoor = "green";
    private static String location1;
    private static String location2;
    private static BufferedImage image1;
    private static BufferedImage image2;
    private static double redR;
    private static double blueR;
    private static double greenR;
    private static boolean notSet = true;
    private static int cond;
    private static int cond2;
    
    /**
     * Sets up the doors.
     */
    public Door() {
        setCurrentDoor(currentDoor);
        if (notSet) {
            Random randR = new Random();
            cond = randR.nextInt(3) + 1;
            cond2 = randR.nextInt(2) + 1;
            setRR();
        }
        image();
    }
    
    /**
     * Gets the images for each door.
     */
    public static void image() {
        if (door1.equals("red")) {
            location1 = "C:\\Users\\Nate\\workspace\\DoorGame\\src\\rsc\\red door.png";
        }
        else if (door1.equals("blue")) {
            location1 = "C:\\Users\\Nate\\workspace\\DoorGame\\src\\rsc\\blue door.png";
        }
        else {
            location1 = "C:\\Users\\Nate\\workspace\\DoorGame\\src\\rsc\\green door.png";
        }
        
        if (door2.equals("red")) {
            location2 = "C:\\Users\\Nate\\workspace\\DoorGame\\src\\rsc\\red door.png";
        }
        else if (door2.equals("blue")) {
            location2 = "C:\\Users\\Nate\\workspace\\DoorGame\\src\\rsc\\blue door.png";
        }
        else {
            location2 = "C:\\Users\\Nate\\workspace\\DoorGame\\src\\rsc\\green door.png";
        }
    
        try {
            image1 = ImageIO.read(new File(location1));
            image2 = ImageIO.read(new File(location2));
        } catch (IOException ex) {
            // handle exception...
        }
    }
    
    /**
     * Changes the scale of the door.
     * @param g for the scaled image
     */
    public void scale(Image g) {
        int x = Room.getScaleX();
        int y = Room.getScaleY();
        g.getScaledInstance(x, y, Image.SCALE_SMOOTH);
    }
    
    /**
     * Gets the open door.
     * @return current door
     */
    public static String getDoor() {
        return currentDoor;
    }
    
    /**
     * Sets the current room.
     * @param c as the new current open door
     */
    public static void setCurrentDoor(String c) {
        currentDoor = c;
    }
    
    /**
     * Sets door 1.
     * @param d door 1
     */
    public static void setDoor1(String d) {
        door1 = d;
    }
    
    /**
     * Gets door 1.
     * @return door 1
     */
    public static String getDoor1() {
        return door1;
    }
    
    /**
     * Sets door 2.
     * @param d door 2
     */
    public static void setDoor2(String d) {
        door2 = d;
    }
    
    /**
     * Gets door 2.
     * @return door 2
     */
    public static String getDoor2() {
        return door2;
    }
    
    /**
     * Gets the first door's image.
     * @return image 1
     */
    public BufferedImage getImage1() {
        return image1;
    }
    
    /**
     * Gets the second door's image.
     * @return image 2
     */
    public BufferedImage getImage2() {
        return image2;
    }
    
    /**
     * Gets the reward amount for each door.
     * @param door as the open door
     * @return the reward for the door
     */
    public static double rewardP(String door) {
        if (door.equals("red")) return redR;
        if (door.equals("blue")) return blueR;
        return greenR;
    }
    
    /**
     * Set the reward for each door randomly between 1, 3, and 6.
     */
    public static void setRR() {
        if (cond == 1) {
            redR = 1;
            if (cond2 == 1) {
                blueR = 3;
                greenR = 6;
            }
            else {
                blueR = 6;
                greenR = 3;
            }
        }
        else if (cond == 2) {
            redR = 3;
            if (cond2 == 1) {
                blueR = 1;
                greenR = 6;
            }
            else {
                blueR = 6;
                greenR = 1;
            }
        }
        else {
            redR = 6;
            if (cond2 == 1) {
                blueR = 3;
                greenR = 1;
            }
            else {
                blueR = 1;
                greenR = 3;
            }
        }
        notSet = false;
    }
}

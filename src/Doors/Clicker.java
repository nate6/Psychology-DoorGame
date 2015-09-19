package Doors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * The clicker bank for the Door Game.
 * 
 * @author Nate Axt
 * @version 9/9/2015
 */
public class Clicker extends JButton {
    private static final long serialVersionUID = 1L;
    private static int clicks = 100;
    private BufferedImage image;
    private static double reward;

    /**
     * Sets up a clicker.
     */
    public Clicker() {
        try {
            image = ImageIO.read(new File("C:\\Users\\Nate\\workspace\\DoorGame\\src\\rsc\\money button.png"));
        } catch (IOException ex) {
            // handle exception
        }
    }
    
    /**
     * Sets the clicker's image.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    
    /**
     * Gets the current clicks.
     * @return current clicks
     */
    public static int getClicks() {
        return clicks;
    }
    
    /**
     * Gets the current reward
     * @return reward
     */
    public static double getReward() {
        return reward;
    }
    
    /**
     * Gets the current reward as a string with three significant figures.
     * @return reward
     */
    public static String getRewardString() {
        return String.format("%.2f", reward);
    }
    
    /**
     * Takes a click away.
     */
    public static void setClicks() {
        if (clicks > 0) {
            clicks = clicks - 1;
        }
    }
    
    /**
     * Gets the reward depending on the room.
     */
    public static void giveReward() {
        if (clicks >= 0) {
            Random rand = new Random();
            reward = rand.nextInt(198);
            Door.setRR();
            if (Door.getDoor().equals("red")) reward = reward / 100 + Door.rewardP("red");
            else if (Door.getDoor().equals("blue")) reward = reward / 100 + Door.rewardP("blue");
            else if (Door.getDoor().equals("green")) reward = reward / 100 + Door.rewardP("green");
        }
        else reward = 0;
    }
    
    /**
     * Resets the clicks to 100.
     */
    public static void refresh() {
        clicks = 100;
    }
}
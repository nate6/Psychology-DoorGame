package Doors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A light image.
 * 
 * @author Nate Axt
 * @version 9/9/2015
 */
public class Light extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage image;

    /**
     * Sets up a new light panel.
     */
    public Light() {
       try {
          image = ImageIO.read(new File("C:\\Users\\Nate\\workspace\\DoorGame\\src\\rsc\\light.png"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    /**
     * Matches the image to the panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}

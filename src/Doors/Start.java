package Doors;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The Instruction Window at the beginning of the game.
 * 
 * @author Nate Axt
 * @version 9/9/2015
 */
public class Start extends JFrame {
    private static final long serialVersionUID = 1L;
    private Font font = new Font("Calibri", Font.BOLD, 34);
    
    /**
     * Sets up a new Start Window
     */
    public Start() {
      //Window
        setTitle("Instructions");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(800, 570);
      
      //Panel
        JPanel s = new JPanel();
        s.setBackground(new Color(0, 200, 55));
        FlowLayout f = new FlowLayout(FlowLayout.LEFT, 5, 5);
        s.setLayout(f);
        
      //Labels
        JLabel t1 = new JLabel();
        JLabel t2 = new JLabel();
        JLabel t3 = new JLabel();
        JLabel t4 = new JLabel();
        JLabel t5 = new JLabel();
        JLabel ins1 = new JLabel();
        JLabel ins2 = new JLabel();
        JLabel ins3 = new JLabel();
        JLabel ins4 = new JLabel();
        JLabel ins5 = new JLabel();
        JLabel ins6 = new JLabel();
        t1.setFont(font);
        t2.setFont(font);
        t3.setFont(font);
        t4.setFont(font);
        t5.setFont(font);
        ins1.setFont(font);
        ins2.setFont(font);
        ins3.setFont(font);
        ins4.setFont(font);
        ins5.setFont(font);
        ins6.setFont(font);
        t1.setText("The Goal is to get as much money as possible.");
        t2.setText("Click on the button in each room to get money.");
        t3.setText("Your total profit is displayed at the top of the screen.");
        t4.setText("The profit from one click appears above the button.");
        t5.setText("Each door has a different amount of money.");
        ins1.setText("You have a limited amount of clicks.");
        ins2.setText("Clicking on a door or button counts as a click.");
        ins3.setText("Click on a door to switch rooms.");
        ins4.setText("The doors will lock after 20 seconds.");
        ins5.setText("Close this window and press Start to begin.             ");
        ins6.setText("Good Luck!");
        
      //Add panel and labels
        s.add(t1);
        s.add(t2);
        s.add(t3);
        s.add(t4);
        s.add(t5);
        s.add(ins1);
        s.add(ins2);
        s.add(ins3);
        s.add(ins4);
        s.add(ins5);
        s.add(ins6);
        add(s);
        
        setVisible(true);
    }
}

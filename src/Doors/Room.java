package Doors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * The Display for the Door Game.
 * NOTE: While writing this program I learned how important it is
 *       to use UML diagrams and fully plan out class structure.
 *       This class is really long and should have been written
 *       with several subclasses instead.
 * 
 * @author Nate Axt
 * @version 9/9/2015
 */
public class Room extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLayeredPane layer = new JLayeredPane();
    private Font font = new Font("Calibri", Font.PLAIN, 30);
    private Font font2 = new Font("Calibri", Font.BOLD, 22);
    private Font font3 = new Font("Calibri", Font.BOLD, 20);
    private Dimension dim = new Dimension(150, 50);
    private Color colorGreen = new Color(0, 200, 55);
    
  //Top Panel
    private JPanel top;
    private JButton buttonStart;
    private JButton buttonRefresh;
    private static JLabel labelClicks;
    private JLabel labelTotal;
    private static JLabel labelTime;
    
  //Doors
    private DoorRed red;
    private DoorBlue blue;
    private DoorGreen green;
    private String door1;
    private String door2;
    private JLabel labTop;
    private boolean doorLimit = false;
    private boolean doorsOpen = true;
    private static int scaleX = 176;
    private int scaleAdderX;
    private static int scaleY = 333;
    private int scaleAdderY;
    
  //Lights
    private Light light1;
    private Light light2;
    
  //Money
    private Clicker button;
    private JLabel reward;
    private double total;
    
  //Timer
    private int s;
    private int interval = 30;
    private boolean start = false;
    private boolean timerOn = true;
    private boolean end = false;
    
  //Message
    private JFrame mes;
    private JButton open;
    private JButton close;
    private boolean messageBool = false;   

    
    /**
     * Sets up the window display for the room
     */
    public Room() {
      //Window
        setTitle("The Door Game");
        setPreferredSize(new Dimension(1200, 800));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        top = new JPanel();
        add(top, BorderLayout.NORTH);
        add(layer, BorderLayout.CENTER);
        
      //Start Button
        buttonStart = new JButton();
        buttonStart.setText("Start");
        buttonStart.setFont(font);
        buttonStart.setBackground(colorGreen);
        buttonStart.addActionListener(this);
        buttonStart.setPreferredSize(dim);
        
      //Clicks Display
        labelClicks = new JLabel();
        labelClicks.setText("     Clicks:  100");
        labelClicks.setFont(font2);
        
      //Total Display
        labelTotal = new JLabel();
        labelTotal.setText("TOTAL:  0");
        labelTotal.setFont(font2);
        
      //Time Display
        labelTime = new JLabel();
        labelTime.setText("Time Remaining:  0:30");
        labelTime.setFont(font2);
        
      //Refresh Button
        buttonRefresh = new JButton();
        buttonRefresh.setText("Refresh");
        buttonRefresh.setFont(font);
        buttonRefresh.setBackground(colorGreen);
        buttonRefresh.addActionListener(this);
        buttonRefresh.setPreferredSize(dim);
        
      //Top Panel
        top.setBackground(Color.lightGray);
        GridLayout grid = new GridLayout(1, 4);
        top.setLayout(grid);
        top.add(buttonStart);
        top.add(labelClicks);
        top.add(labelTotal);
        top.add(labelTime);
        top.add(buttonRefresh);
        
      //Game Panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, 1200, 800);
        panel.setOpaque(true);
      
      //Light Images
        light1 = new Light();
        light1.setBounds(200, 150, 217, 451);
        light1.setOpaque(true);
        light2 = new Light();
        light2.setBounds(765, 150, 217, 451);
        light2.setOpaque(true);
        
      //Rewards
        reward = new JLabel();
        reward.setOpaque(true);
        
      //Money Button
        button = new Clicker();
        button.setBounds(545, 300, 85, 85);
        button.setOpaque(true);
        button.addActionListener(this);
        
      //Doors
        red = new DoorRed();
        blue = new DoorBlue();
        green = new DoorGreen();
        layer.add(red, new Integer(0), 0);
        layer.add(blue, new Integer(0), 0);
        layer.add(green, new Integer(0), 0);
        setDoors(); 
        
      //Room Label
        labTop = new JLabel();
        label(false);
        
      //Layer Setup
        add(layer);
        layer.setBounds(0, 0, 1200, 800);
        layer.add(panel, new Integer(0), 0);
        layer.add(light1, new Integer(1), 0);
        layer.add(light2, new Integer(1), 0);
        layer.add(button, new Integer(1), 0);
        if (door1.equals("red") || door2.equals("red")) layer.add(red, new Integer(1), 0);
        if (door1.equals("blue") || door2.equals("blue")) layer.add(blue, new Integer(1), 0);
        if (door1.equals("green") || door2.equals("green")) layer.add(green, new Integer(1), 0);
        
        setSize(1200, 800);
        setCenter(this);
        pack();
        setVisible(true);
    }
    
    /**
     * makes a new instance of room
     * @param args ERROR 404
     */
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Room room = new Room();
        Start start = new Start();
        setCenter(start);
    }
    
    /**
     * Centers the window.
     */
    public static void setCenter(JFrame j) {
        Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
        j.setLocation(dimen.width / 2 - j.getSize().width / 2, dimen.height / 2 - j.getSize().height/2);
    }
    
    /**
     * Sets the two displayed doors.
     */
    public void setDoors() {
        layer.remove(red);
        layer.remove(blue);
        layer.remove(green);
        layer.add(light1, new Integer(1), 0);
        layer.add(light2, new Integer(1), 0);
        getDoors();
        if (door1.equals("red")) {
            red = new DoorRed();
            red.setBounds(220 + scaleAdderX, 214 + scaleAdderY, scaleX, scaleY);
            red.setOpaque(true);
            red.addActionListener(this);
            layer.add(red, new Integer(1), 0);
        }
        if (door1.equals("blue")) {
            blue = new DoorBlue();
            blue.setBounds(220 + scaleAdderX, 214 + scaleAdderY, scaleX, scaleY);
            blue.setOpaque(true);
            blue.addActionListener(this);
            layer.add(blue, new Integer(1), 0);
        }
        if (door1.equals("green")) {
            green = new DoorGreen();
            green.setBounds(220 + scaleAdderX, 214 + scaleAdderY, scaleX, scaleY);
            green.setOpaque(true);
            green.addActionListener(this);
            layer.add(green, new Integer(1), 0);
        }
        if (door2.equals("red")) {
            red = new DoorRed();
            red.setBounds(785 + scaleAdderX, 214 + scaleAdderY, scaleX, scaleY);
            red.setOpaque(true);
            red.addActionListener(this);
            layer.add(red, new Integer(1), 0);
        }
        if (door2.equals("blue")) {
            blue = new DoorBlue();
            blue.setBounds(785 + scaleAdderX, 214 + scaleAdderY, scaleX, scaleY);
            blue.setOpaque(true);
            blue.addActionListener(this);
            layer.add(blue, new Integer(1), 0);
        }
        if (door2.equals("green")) {
            green = new DoorGreen();
            green.setBounds(785 + scaleAdderX, 214 + scaleAdderY, scaleX, scaleY);
            green.setOpaque(true);
            green.addActionListener(this);
            layer.add(green, new Integer(1), 0);
        }
        add(layer);
    }
    
    /**
     * Returns the open door.
     */
    public void getDoors() {
        if (Door.getDoor1().equals("red")) door1 = "red";
        else if (Door.getDoor1().equals("blue")) door1 = "blue";
        else door1 = "green";
        
        if (Door.getDoor2().equals("red")) door2 = "red";
        else if (Door.getDoor2().equals("blue")) door2 = "blue";
        else door2 = "green";
    }
    
    /**
     * Changes the current open door.
     * @param door as the newly opened door
     */
    public void doorRefresh(String door) {
        if (door.equals("red")) {
            Door.setCurrentDoor("red");
            Door.setDoor1("blue");
            Door.setDoor2("green");
        }
        else if (door.equals("blue")) {
            Door.setCurrentDoor("blue");
            Door.setDoor1("green");
            Door.setDoor2("red");
        }
        else {
            Door.setCurrentDoor("green");
            Door.setDoor1("red");
            Door.setDoor2("blue");
        }
        Door.image();
        setDoors();
    }
    
    /**
     * The size of a door's width.
     * @return the door's width
     */
    public static int getScaleX() {
        return scaleX;
    }
    
    /**
     * The size of a door's height.
     * @return the door's height
     */
    public static int getScaleY() {
        return scaleY;
    }
    
    /**
     * Gets the reward after clicking the money button.
     */
    public void reward() {
        layer.remove(reward);
        reward.setText("        $" + Clicker.getRewardString());
        reward.setForeground(Color.yellow);
        reward.setBackground(Color.black);
        reward.setFont(font);
        Random rand = new Random();
        int x = rand.nextInt(60);
        int y = rand.nextInt(60);
        reward.setBounds(460 + x, 40 + y, 200, 200);
        layer.add(reward, new Integer(1), 0);
    }
    
    /**
     * A continuously running timer.
     */
    public void timer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (start && !messageBool) {
                    if(interval == 1) cancel();
                    s = --interval;
                    labelTime.setText("Time Remaining:  " + getTime() + "    ");
                    if (interval == 20) {
                        doorLimit = true;
                    }
                    else if (interval == 0) {
                        scaleX = 0;
                        scaleY = 0;
                        message("  Game Over...     Your Score: $" 
                                + String.format("%.2f", total), "  Retry?", true);
                    }
                    label(true);
                    if (interval <= 20 && interval >= 0) setDoors(); //49 40
                }
            }
        }, 1000, 1000);
    }
    
    /**
     * Sets the display for the current room.
     * @param change if the doors will change size
     */
    public void label(boolean change) {
        layer.remove(labTop);
        if (doorLimit && change) {
            scaleX = scaleX - 9;
            scaleY = scaleY - 18;
            scaleAdderX = 176 / 2 - scaleX / 2;
            scaleAdderY = 333 - scaleY;
        }
        else labTop.setText(Door.getDoor() + " room");
        if (Door.getDoor().equals("red")) labTop.setForeground(Color.red);
        else if (Door.getDoor().equals("blue")) labTop.setForeground(Color.blue);
        else labTop.setForeground(Color.green);
        labTop.setBackground(Color.black);
        labTop.setFont(font);
        labTop.setBounds(10, 10, 450, 50);
        layer.add(labTop, new Integer(1), 0);
    }
    
    /**
     * The current time to display.
     * @return the current time
     */
    public String getTime() {
        if (s == 0) return "0:00";
        if (s >= 10) return "0:" + s; 
        return "0:0" + s;
    }
    
    /**
     * Sets up a small message window.
     * @param message for the string that will be displayed
     * @param mes2 for the second displayed string if there is one
     * @param buttons if the message will have yes and no buttons
     */
    public void message(String message, String mes2, boolean buttons) {
        mes = new JFrame();
        mes.setResizable(false);
        mes.setSize(400, 150);
        mes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        JPanel type = new JPanel();
        type.setBackground(colorGreen);
        JLabel label = new JLabel();
        label.setFont(font3);
        label.setText(message);
        FlowLayout fL = new FlowLayout(FlowLayout.LEFT, 5, 5);
        type.setLayout(fL);
        type.add(label);
        
        if (buttons) {
            open = new JButton();
            open.setFont(font3);
            open.setBackground(Color.lightGray);
            open.setText("Yes");
            open.addActionListener(this);
            
            close = new JButton();
            close.setFont(font3);
            close.setBackground(Color.lightGray);
            close.setText("No");
            close.addActionListener(this);
            
            JPanel buts = new JPanel();
            buts.setBackground(colorGreen);
            FlowLayout f = new FlowLayout(FlowLayout.RIGHT, 5, 5);
            buts.setLayout(f);
            buts.add(open);
            buts.add(close);
            
            mes.add(type, BorderLayout.NORTH);
            mes.add(buts, BorderLayout.SOUTH);
        }
        else {
            mes.add(type);
        }
        
        JPanel center = new JPanel();
        center.setBackground(colorGreen);
        JLabel label2 = new JLabel();
        label2.setFont(font3);
        label2.setText(mes2);
        center.add(label2);
        center.setLayout(fL);
        mes.add(center, BorderLayout.CENTER);
        
        setCenter(mes);
        mes.setVisible(true);
        messageBool = true;
    }
    
    /**
     * Sets the actions for all buttons.
     */
    public void actionPerformed(ActionEvent ae) {
      //Money Button Reward
        if (ae.getSource() == button && start && Clicker.getClicks() != 0) {
            Clicker.giveReward();
            reward();
            total = total + Clicker.getReward();
            labelTotal.setText("TOTAL:  " + String.format("%.2f", total));
        }
      //Loosing Clicks
        if ((ae.getSource() == red || ae.getSource() == blue ||
                ae.getSource() == green || ae.getSource() == button) && start) {
            Clicker.setClicks();
            labelClicks.setText("     Clicks:  " + Clicker.getClicks());
            if (Clicker.getClicks() == 0 && !messageBool) {
                message("  Game Over...     Your Score: $" + String.format("%.2f", total), "  Retry?", true);
                end = true;
            }
        }
      //Start Button
        if (ae.getSource() == buttonStart) {
            start = true;
            if (timerOn) {
                timer();
                timerOn = false;
            }
        }
      //Refresh Button
        if (ae.getSource() == buttonRefresh) {
            message(" Are you sure you want to Restart?", "",true);
        }
      //Opens Red Room
        if (ae.getSource() == red && start && doorsOpen) doorRefresh("red");
      //Opens Blue Room
        if (ae.getSource() == blue && start && doorsOpen) doorRefresh("blue");
      //Opens Green Room
        if (ae.getSource() == green && start && doorsOpen) doorRefresh("green");
      //If "Yes" is clicked on message
        if (ae.getSource() == open) {
            labelTime.setText("Time Remaining:  0:30");
            labelClicks.setText("     Clicks:  100");
            interval = 30;
            s = 0;
            start = false;
            Clicker.refresh();
            doorRefresh("green");
            mes.dispatchEvent(new WindowEvent(mes, WindowEvent.WINDOW_CLOSING));
            messageBool = false;
            doorLimit = false;
            doorsOpen = true;
            end = false;
            layer.remove(reward);
            scaleX = 176;
            scaleY = 333;
            scaleAdderX = 0;
            scaleAdderY = 0;
            setDoors();
            total = 0;
            labelTotal.setText("TOTAL:  " + String.format("%.2f", total));
        }
      //If "No" is clicked on message
        if (ae.getSource() == close) {
            mes.dispatchEvent(new WindowEvent(mes, WindowEvent.WINDOW_CLOSING));
            messageBool = false;
            if (end) dispatchEvent(new WindowEvent(mes, WindowEvent.WINDOW_CLOSING));
        }
      //Refreshes label
        label(false);
    }
}
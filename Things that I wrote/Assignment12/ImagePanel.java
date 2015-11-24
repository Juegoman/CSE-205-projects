// Assignment #: 12
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: A class that represents a panel that contains a moving image 
//               controlled by a timer, as well as methods for controlling it.

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JPanel {

    private Color backColor;
    private int x, y, delay, stepX, stepY;
    private final int IMAGE_DIAMETER;
    private Timer timer;
    private ImageIcon image;

    //constructor
    public ImagePanel(int x, int y, Color bg) {

        this.x = x;
        this.y = y;
        
        backColor = bg;
        setBackground(bg);
        
        delay = 20;
        stepX = 3;
        stepY = 0;
        IMAGE_DIAMETER = 20;

        timer = new Timer(delay, new MoveListener());
        timer.start();


    }

    //sets the image moving upwards
    public void up() {

        stepX = 0;
        stepY = -3;

        timer.start();

    }

    //sets the image moving downwards
    public void down() {

        stepX = 0;
        stepY = 3;

        timer.start();

    }

    //sets the image moving to the left
    public void left() {

        stepX = -3;
        stepY = 0;

        timer.start();

    }

    //sets the image moving to the right
    public void right() {

        stepX = 3;
        stepY = 0;

        timer.start();

    }

    //stops the image
    public void suspend() {

        timer.stop();

    }

    //sets the speed of the image
    public void setDelay(int n) {

        delay = n;
        timer.setDelay(delay);

    }

    //paints the image on the panel
    @Override
    public void paintComponent(Graphics page) {

        super.paintComponent(page);

        image = null;
        try {

            image = new ImageIcon(ImageIO.read(new File("happyFace.gif")));
            image.paintIcon(this, page, x, y);

        } catch (IOException e) {
        }
    }

    private class MoveListener implements ActionListener {

        //logic for moving the image
        @Override
        public void actionPerformed(ActionEvent e) {

            x += stepX;
            y += stepY;

            if ((x < 0) || (x > getSize().getWidth() - IMAGE_DIAMETER) && stepY == 0) {
                stepX = stepX * -1;
            }

            if ((y < 0) || (y > getSize().getHeight() - IMAGE_DIAMETER) && stepX == 0) {
                stepY = stepY * -1;
            }

            repaint();

        }
    }
}
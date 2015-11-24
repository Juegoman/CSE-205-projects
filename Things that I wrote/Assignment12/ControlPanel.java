// Assignment #: 12
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: ControlPanel class extends JPanel and contains 5 buttons and
// 		 1 slider that control the change in movement of the image. Also
//		 contains two subclasses that implement Listener interfaces,
//		 which are then used on the buttons and slider.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel {

    //Declare instance variables
    private ImagePanel face;
    private int width, height;
    private JSlider slider;
    private JButton u, d, l, r, s; //up, down, left, right, stop

    // Constructor
    // Creates all of the components (JButtons, JSlider, and ImagePanel) and adds Listeners
    // to them, and adds the components to the panel. Sets the size of the panel.
    public ControlPanel(int width, int height) {
        this.width = width;
        this.height = height;

        // create an ImagePanel
        face = new ImagePanel(0, 0, Color.red);
        // creat panels with appropriate layouts

        setLayout(new GridLayout(1, 2));

        JPanel left = new JPanel(new GridLayout(2, 1));
        JPanel upperLeftButtons = new JPanel(new GridLayout(5, 1));

        add(left);
        add(face);
        left.add(upperLeftButtons);

        // create your buttons
        // add Listener to your buttons
        u = new JButton("Up");
        u.addActionListener(new ButtonListener());
        upperLeftButtons.add(u);

        d = new JButton("Down");
        d.addActionListener(new ButtonListener());
        upperLeftButtons.add(d);

        l = new JButton("Left");
        l.addActionListener(new ButtonListener());
        upperLeftButtons.add(l);

        r = new JButton("Right");
        r.addActionListener(new ButtonListener());
        upperLeftButtons.add(r);

        s = new JButton("Stop");
        s.addActionListener(new ButtonListener());
        upperLeftButtons.add(s);

        // create slider use new JSlider(SwingConstants.VERTICAL, 0, 50, 20);
        slider = new JSlider(SwingConstants.VERTICAL, 0, 50, 20);

        // add ChangeListner to the slider
        // use the method setPaintLabels(true)
        // use the setLabelTable(slider.createStandardLabels(10));
        slider.addChangeListener(new SliderListener());
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(10));

        // add panels to the main panel
        left.add(slider);


    }

    private class ButtonListener implements ActionListener {

        // actionPerformed
        // Must be defined from the ActionListener class. Takes the button that
        // has been pressed and changes the motion of the image accordingly.
        @Override
        public void actionPerformed(ActionEvent event) {

            Object action = event.getSource();
            // decide which button is clicked

            if (action == u) {
                face.up();
            }
            if (action == d) {
                face.down();
            }
            if (action == l) {
                face.left();
            }
            if (action == r) {
                face.right();
            }
            if (action == s) {
                face.suspend();
            }

        }
    } //end of ButtonListener

    private class SliderListener implements ChangeListener {

        // stateChanged
        // Must be defined from the ChangeListener class. Takes the value of the
        // slider and sets the delay of the iamge Timer to that value.
        @Override
        public void stateChanged(ChangeEvent event) {

            face.setDelay(slider.getValue());

        }
    } //end of SliderListener
} //end of ControlPanel

// Assignment #: 12
//         Name: Ruben
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.

import javax.swing.*;

public class Assignment12 extends JApplet {

    private final int WIDTH = 550;
    private final int HEIGHT = 250;

    @Override
    public void init() {
        ControlPanel panel = new ControlPanel(WIDTH, HEIGHT);
        getContentPane().add(panel);
    }
}
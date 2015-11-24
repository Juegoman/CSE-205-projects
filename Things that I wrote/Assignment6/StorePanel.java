// Assignment #: 6
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: The StorePanel class presents a grapical user interface to 
//              allow a user to input information for a personal computer to be
//              added to a list and purchased later.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StorePanel extends JPanel {
    private ArrayList compList;
    private PurchasePanel purchasePanel;
    
    private JTextField brand, price, mem, type, speed;
    private JLabel statusMessage;
    private JTextArea displayList;
    
    public StorePanel(ArrayList compList, PurchasePanel pPanel) {
        this.compList = compList;
        this.purchasePanel = pPanel;
        
        //create a left and right JPanel
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        
        //set the layout of the base StorePanel
        setLayout(new GridLayout(1,2));
        
        //add the left JPanel and set its layout
        add(left);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        
        //add the red JLabel. it's not shown until a message is written.
        statusMessage = new JLabel();
        statusMessage.setForeground(Color.red);
        left.add(statusMessage);
        
        //add an inner JPanel to hold the JLabels and JTextFields. Set its layout.
        JPanel innerLeft = new JPanel();
        left.add(innerLeft);
        innerLeft.setLayout(new GridLayout(5,2));
        
        //add all of the JLabels and JTextFields to the inner JPanel.                
        innerLeft.add(new JLabel("Brand Name"));
        brand = new JTextField();
        innerLeft.add(brand);
        
        innerLeft.add(new JLabel("Price"));
        price = new JTextField();
        innerLeft.add(price);
        
        innerLeft.add(new JLabel("Memory"));
        mem = new JTextField();
        innerLeft.add(mem);
        
        innerLeft.add(new JLabel("CPU Type"));
        type = new JTextField();
        innerLeft.add(type);
        
        innerLeft.add(new JLabel("CPU Speed"));
        speed = new JTextField();
        innerLeft.add(speed);
                
        //add the JButton to the left JPanel. Connect its listener.
        JButton storeButton = new JButton("Store");
        storeButton.addActionListener(new ButtonListener());
        left.add(storeButton);
        
        //add the right JPanel. Add the JTextArea with a default message.
        add(right);        
        displayList = new JTextArea("No Computer");        
        right.setLayout(new GridLayout(1,1));
        right.add(displayList);
        
    }



    private class ButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            //try to catch NullPointerException from .getText() and 
            //NumberFormatException from .parseInt() and .parseDouble().
            try {
                
                //Collect all of the information from the JTextFields
                String brandName = brand.getText();
                double prce = Double.parseDouble(price.getText());
                int memory = Integer.parseInt(mem.getText());
                String cpuType = type.getText();
                int spd = Integer.parseInt(speed.getText());
                
                //to check if String fields are not blank
                boolean cont = true;
                
                //if Brand Name or CPU Type are blank
                if(brandName.equals("")||cpuType.equals("")) {
                    
                    //output error message and stop
                    statusMessage.setText("Please enter all fields.");
                    cont = false;
                    
                }
                
                //if String fields are not blank
                if(cont) {
                    
                    //make a Computer and fill in info
                    Computer compy = new Computer();
                    compy.setBrandName(brandName);
                    compy.setCPU(cpuType, spd);
                    compy.setMemory(memory);
                    compy.setPrice(prce);
                    
                    //add the computer to the ArrayList
                    compList.add(compy);

                    //print success message
                    statusMessage.setText("Computer added.");

                    //update computer list
                    String newList = "";
                    for(Object c : compList) {
                        
                        //add computers to the list
                        newList = newList + c;

                    }
                    
                    //overwrite the JTextArea with the new list of computers
                    displayList.setText(newList);
                    
                    //update the purchasePanel with the new Computer
                    purchasePanel.update();
                }
                
            //if the fields are null    
            } catch(NullPointerException e){

                statusMessage.setText("Please enter all fields.");
            
            //if the number fields contain non-numbers
            } catch(NumberFormatException e) {
                
                statusMessage.setText("Enter a number for price, memory, or speed.");
                
            } 
            
        }
        
    }

}

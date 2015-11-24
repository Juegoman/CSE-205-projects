// Assignment #: 6
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: The PurchasePanel class shows a graphical user interface
//              to compute the total price of input computers when purchasing 
//              by utilizing JCheckBox and associated event listeners.

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PurchasePanel extends JPanel {
    private ArrayList compList, checkboxes;
    private JTextArea purchaseTotal;
    private JPanel left;

    public PurchasePanel(ArrayList compList) {
        this.compList = compList;

        //sets the overarching layout to x-axis BoxLayout
	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        //create, add, and set y-axis BoxLayout to the left and right 
        //portions of the pane
        left = new JPanel();
        add(left);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        
        JPanel right = new JPanel();
        add(right);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        
        //create and add the right JLabel and JTextArea.
        //Instantiate the JTextArea.
        right.add(new JLabel("Current Total Purchase"));
        purchaseTotal = new JTextArea("$0.00");
        right.add(purchaseTotal);
        
        //prepare the checkbox ArrayList
        checkboxes = new ArrayList();
               
    }

    private class CheckBoxListener implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent event) {
            // compute the total purchase amount when a check box is
            // checked or unchecked.
            
            //prepare the total
            double total = 0.0;
            
            //loop through the checkboxes
            for (int i = 0; i < checkboxes.size(); i++) {
                
                //get the JCheckBox in the current index of the ArrayList.
                //cast JCheckBox since ArrayList is holding Objects.
                JCheckBox chkbx = (JCheckBox) checkboxes.get(i);
                
                //if the checkbox is checked
                if(chkbx.isSelected()) {
                    
                    //get the Computer in the current index of the ArrayList.
                    //cast Computer since ArrayList is holding Objects.
                    Computer selected = (Computer) compList.get(i);
                    
                    //add the price of the Computer to the total.
                    total += selected.getPrice();
                    
                }
            }
            
            //format and overwrite the old total with the new total.
            java.text.NumberFormat fmt = java.text.NumberFormat.getCurrencyInstance();
            purchaseTotal.setText(fmt.format(total));
	}
        
    }
    
    public void update() {
        
        //create a new JCheckBox from the last Computer to be added to the 
        //compList ArrayList.
        JCheckBox newCheckBox = new JCheckBox(compList.get(compList.size()-1).toString());
        
        //add the checkbox to the left JPanel
        left.add(newCheckBox);
        
        //connect the ItemListener to the new JCheckBox
        newCheckBox.addItemListener(new CheckBoxListener());
        
        //add the new JCheckBox to the ArrayList of JCheckBoxes
        checkboxes.add(newCheckBox);
    
    }

}

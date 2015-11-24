// Assignment #: 5
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: A class representing a student taking online classes at a university.

import java.text.DecimalFormat; //to format currency

public class OnlineStudent extends Student {
    
    private double computingFee;
    
    public OnlineStudent(String fName, String lName, String id, int credits, double rate, double compFee) {
        
        super(fName, lName, id, credits, rate); //call parent's constructor
        
        this.computingFee = compFee; //define unique variable
        
    }
    
    @Override
    public void computeTuition() {
        
        this.tuition = (this.rate + this.computingFee) * this.creditNum; //computes tuition for an online student
    
    }
    
    @Override
    public String toString() { //returns information about an online student
        
        DecimalFormat fmt = new DecimalFormat("$#,###,##0.00"); //appends a dollar sign and adds commas and a point to a number
        
        return ("\nOnline Student:" 
                + super.toString() //returns a string containing generic information about the student
                + "Computing Fee:\t\t" + fmt.format(this.computingFee)+"\n\n");
        
    }
    
}
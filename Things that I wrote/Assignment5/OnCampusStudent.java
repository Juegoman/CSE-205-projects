// Assignment #: 5
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: A class representing a student taking classes on campus at a university.

import java.text.DecimalFormat; //to format currency

public class OnCampusStudent extends Student {
    
    private boolean resident;
    private int creditUpperbound;
    private double studentProgramFee;
    
    public OnCampusStudent(String fName, String lName, String id, int credits, double rate, boolean resident, double programFee) {
        
        super(fName, lName, id, credits, rate); //call parent's constructor
        
        this.resident = resident;
        
        if (resident) //if the student is a resident...
            this.creditUpperbound = 7; //set his upperbound credits to 7
        else
            this.creditUpperbound = 12; //otherwise set them to 12
        
        this.studentProgramFee = programFee; //assign unique variable
        
    }

    @Override
    public void computeTuition() { //computes tuition for an online student
        
        if (this.creditNum >= this.creditUpperbound) //if number of credits is greater than or equal to the upperbound...
            this.tuition = this.rate * this.creditUpperbound + this.studentProgramFee; //multiply the rate by the upperbound
        else 
            this.tuition = this.rate * this.creditNum + this.studentProgramFee; //otherwise multiply the rate by the number of credits
        
    }
    
    @Override
    public String toString() { //returns information about an on campus student
        
        DecimalFormat fmt = new DecimalFormat("$#,###,##0.00"); //appends a dollar sign and adds commas and a point to a number
        
        String ret = "\nOnCampus Student:"; 
        if (this.resident) //if the student is a resident...
            ret = ret + "\nResident Status"; //append resident status to info
        else
            ret = ret + "\nNonResident Status"; //otherwise append nonresident status
        
        return (ret + super.toString() //returns a string containing generic information about the student
                + "Student Program Fee:\t" + fmt.format(this.studentProgramFee) + "\n\n");
        
        
    }
    
}
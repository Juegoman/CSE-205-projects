// Assignment #: 5
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: Absract class representing a generic student attending a university.

import java.text.DecimalFormat; //to format currency

public abstract class Student { 
    
    protected String firstName, lastName, studentID;
    protected int creditNum;
    protected double rate, tuition;
    
    public Student(String fName, String lName, String id, int credits, double rate) {
        
        //assign all variables
        this.firstName = fName;
        this.lastName = lName;
        this.studentID = id;
        this.creditNum = credits;
        this.rate = rate;
        this.tuition = 0.0;
        
    }
    
    public int getCreditNum() {
        
        return this.creditNum; //return number of credits
        
    }
    
    public abstract void computeTuition(); //to be defined in child classes
    
    @Override
    public String toString() { //returns generic information about a student
        
        DecimalFormat fmt = new DecimalFormat("$#,###,##0.00"); //appends a dollar sign and adds commas and a point to a number
        
        return ("\nFirst name:\t\t"+this.firstName
                +"\nLast name:\t\t"+this.lastName
                +"\nStudent ID:\t\t"+this.studentID
                +"\nCredits:\t\t"+this.creditNum
                +"\nRate:\t\t\t"+fmt.format(this.rate)
                +"\nTuition:\t\t"+fmt.format(this.tuition)
                +"\n");
        
    }
    
}
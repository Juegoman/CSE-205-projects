// Assignment #: 5
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: A utility class used to create Student objects from strings.

public class StudentParser {
    
    public static Student parseStringToStudent(String lineToParse) {
        
        String[] info; //String array to hold elements of student object
        
        if (lineToParse.substring(0, 3).equalsIgnoreCase("onl")) { //check if student is online
            
            info = lineToParse.split("/"); //split the line to parse into separate elements
            return new OnlineStudent(info[1], info[2], info[3], Integer.parseInt(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6])); //create an OnlineStudent with the parsed elements
            
        }else if (lineToParse.substring(0, 3).equalsIgnoreCase("onc")) { //check if the student is on campus
            
            info = lineToParse.split("/");//split the line to parse into separate elements
            return new OnCampusStudent(info[1], info[2], info[3], Integer.parseInt(info[4]), Double.parseDouble(info[5]), residency(info[6]), Double.parseDouble(info[7])); //create an OnCampusStudent with the parsed elements
            
            
        }else {
            
            return null; //default case
            
        }
        
    }
    
    private static boolean residency(String res) { //method to parse string "Resident" to true and anything else to false
        
        if (res.equalsIgnoreCase("Resident"))
            return true;
        else 
            return false;
        
    }
    
}
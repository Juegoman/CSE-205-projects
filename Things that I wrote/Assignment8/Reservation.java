// Assignment #: 8
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: A list of passengers and flights and methods to manupulate
//               these lists

import java.util.ArrayList;

public class Reservation implements java.io.Serializable {
    
    ArrayList passengerList, flightList;
    
    //Constructor, instantiates lists
    public Reservation() {
        
        passengerList = new ArrayList();
        flightList = new ArrayList();
        
    }
    
    //searches for a passenger by ID. returns index of passenger in 
    //passengerList if found, otherwise returns -1
    public int passengerExists(String pass) {
        Passenger p;
        for (int i = 0; i < passengerList.size(); i++) {
            
            p = (Passenger) passengerList.get(i);
            if (p.getPassengerID().equals(pass)) {
                return i;
            }
            
        }
        
        return -1;
    }
    
    //creates a passenger from a passed String, checks to see if passenger
    //doesn't exist, if it doesn't then adds passenger to the list and returns 
    //true, otherwise returns false.
    public boolean addPassenger(String pass) {
        
        Passenger newPass = PassengerParser.parseStringToPassenger(pass);
        
        if(this.passengerExists(newPass.getPassengerID()) == -1) {
            
            passengerList.add(newPass);
            return true;
            
        }else return false;
                
    }
    
    //checks to see if passed in ID belongs to a passenger in the list. if it 
    //doesn't then returns false, otherwise removes matching passenger and 
    //returns true.
    public boolean removePassenger(String pass) {
        
        if(this.passengerExists(pass) == -1) return false;
        else {
            
            passengerList.remove(this.passengerExists(pass));
            return true;
            
        }
        
    }
    
    //sorts passenger list using sort method.
    public void sortPassengers() {
        
        Sorts.sort(passengerList);
        
    }
    
    //lists all of the toString methods of the passengers in the passengerList
    public String listPassengers() {
        
        String ret = "";
        if(passengerList.isEmpty()) return "no passenger\n";
        else {
            for(Object p : passengerList) {
                ret = ret + p.toString();
            }
        }
        
        return ret;
        
    }
    
    //searches for a flight by it's properties. returns index of flight in 
    //flightList if found, otherwise returns -1
    public int flightExists(String airlinesName, String flightNum, String depCity) {
        
        Flight f;
        
        for(int i = 0; i < flightList.size(); i++) {
            
            f = (Flight) flightList.get(i);
            if(f.getAirlines().equals(airlinesName) && f.getFlightNum().equals(flightNum) && f.getDeparture().getCity().equals(depCity)) return i;
            
        }
        
        return -1;
    }
    
    //creates a flight from a passed String, checks to see if flight
    //doesn't exist, if it doesn't then adds flight to the list and returns 
    //true, otherwise returns false.
    public boolean addFlight(String flight) {
        
        Flight newFlight = FlightParser.parseStringToFlight(flight);
        
        if(this.flightExists(newFlight.getAirlines(), newFlight.getFlightNum(), newFlight.getDeparture().getCity()) == -1) {
            
            flightList.add(newFlight);
            return true;
            
        }else return false;
        
    }
    
    //checks to see if passed in attributes belong to a flight in the list. if it 
    //doesn't then returns false, otherwise removes matching flight and 
    //returns true.
    public boolean removeFlight(String airlinesName, String flightNum, String depCity) {
        
        if(this.flightExists(airlinesName, flightNum, depCity) == -1) return false;
        else {
            
            flightList.remove(this.flightExists(airlinesName, flightNum, depCity));
            return true;
            
        }
        
    }
    
    //sorts flight list using sort method.
    public void sortFlights() {
        
        Sorts.sort(flightList);
        
    }
    
    //lists all of the toString methods of the flights in the flightList
    public String listFlights() {
        
        String ret = "";
        if(flightList.isEmpty()) return "no flight\n";
        else {
            for(Object p : flightList) {
                ret = ret + p.toString();
            }
        }
        
        return ret;
        
    }
    
    //clears the passenger and flight lists
    public void closeReservation() {
        passengerList.clear();
        flightList.clear();
    }
}
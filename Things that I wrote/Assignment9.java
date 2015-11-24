// Assignment #: 9
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: This program reads numbers and performs various recursive 
//               operations on them

import java.io.*;

public class Assignment9 {
    
    public static void main(String[] args){
        
        //instantiate variables
        String line = "";
        int[] arr = new int[100];
        int count = 0, key = 0;
        boolean cont = true;
        
        //to catch exceptions
        try {
            
            //to read input
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(isr);
            
            //input loop, reads until 0 is input
            while(cont) {
                
                line = in.readLine().trim();
                arr[count] = Integer.parseInt(line);
                if(arr[count] == 0) {
                    cont = false;
                }else count++;
            
            }
            
            //reads one last time after 0 to get key
            key = Integer.parseInt(in.readLine().trim());
                                    
        }catch (IOException e) {
            //catch
            System.out.print("IOException");
            
        }catch (NumberFormatException e) {
            //catch
            System.out.print("NumberFormatException");
            
        }
        
        //perform operations
        System.out.println("The maximum number is: " + findMax(arr, 0, count));
        System.out.println("The count of positive integers is: " + countPositive(arr, 0, count));
        System.out.println("The sum of the numbers divisible by 3 is: " + computeSumDivisibleBy3(arr, 0, count));
        System.out.println("The search key is at index: " + exists(arr, 0, key));
        
    }
    
    public static int findMax(int[] numbers, int startIndex, int endIndex) {
        
        //if there is only one element in the sub array, return that element
        if(startIndex == endIndex) {
            
            return numbers[startIndex];
            
        }else {
         
            //get the mid point of the array
            int mp = (startIndex + endIndex) / 2;
            
            //split the array into sub arrays to be able to compare the numbers
            int lMax = findMax(numbers, startIndex, mp);
            int rMax = findMax(numbers, mp + 1, endIndex);
            
            //compare the returned numbers and return the result
            if(lMax > rMax) return lMax;
            else return rMax;
            
        }
        
    }
    
    public static int countPositive(int[] numbers, int startIndex, int endIndex) {
        
        //if there is only one element in the sub array, see if it's greater
        //than 0, and return accordingly
        if(startIndex == endIndex) {
            
            if(numbers[startIndex] > 0) return 1;
            else return 0;
            
        }else {
            
            //get the mid point of the array
            int mp = (startIndex + endIndex) / 2;
            
            //split the array into subarrays to be able to count the numbers
            int lCount = countPositive(numbers, startIndex, mp);
            int rCount = countPositive(numbers, mp + 1, endIndex);
            
            //sum the returned values and return it
            return lCount + rCount;
            
        }
        
    }
    
    public static int computeSumDivisibleBy3(int[] numbers, int startIndex, int endIndex) {
        //if there is only one element in the sub array, see if it's divisible 
        //by 3, and return accordingly
        if(startIndex == endIndex) {
            
            if(numbers[startIndex] % 3 == 0) return numbers[startIndex];
            else return 0;
            
        }else {
            
            //get the mid point of the array
            int mp = (startIndex + endIndex) / 2;
            
            //split the array into subarrays to be able to count the numbers
            int lCount = computeSumDivisibleBy3(numbers, startIndex, mp);
            int rCount = computeSumDivisibleBy3(numbers, mp + 1, endIndex);
            
            //sum the returned values and return it
            return lCount + rCount;
            
        }
           
    }
    
    public static int exists( int[] array, int lastIndex, int searchElement) {
        
        //if the index is at the end of the array, return -1,  the element is
        //not in the array
        if(lastIndex == array.length) return -1;
        else {
            
            //check to see if the current element is the target
            if(array[lastIndex] == searchElement) return lastIndex;
            //if not, run again with an incremented index
            else return exists(array, lastIndex + 1, searchElement);
            
        }
        
    }
}
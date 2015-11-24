// Assignment #: 10
//         Name: 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: Assignment 10 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;
import java.util.NoSuchElementException;

public class Assignment10
{
   public static void main(String[] args)
   {
       char input1;
       int inputInteger;
       String inputInfo = " ";
       int operation2;
       String line = new String();

       //create a linked list to be used in this method.
       LinkedList list1 = new LinkedList();

       try
        {
         // print out the menu
         printMenu();

         // create a BufferedReader object to read input from a keyboard
         InputStreamReader isr = new InputStreamReader (System.in);
         BufferedReader stdin = new BufferedReader (isr);

         do
          {
           System.out.print("What action would you like to perform?\n");
           line = stdin.readLine().trim();  //read a line
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           if (line.length() == 1)   //check if a user entered only one character
            {
             switch (input1)
              {
               case 'A':   //Add
                 System.out.print("Please enter an integer to add:\n");
                 int int1 = Integer.parseInt(stdin.readLine().trim());
                 System.out.print("Please enter an index to add:\n");
                 inputInfo = stdin.readLine().trim();
                 int addIndex = Integer.parseInt(inputInfo);
                 list1.addElement(addIndex, int1);
                 break;
               case 'E':   //Search for an integer at an Index
                 System.out.print("Please enter an index to search:\n");
                 int searchIndex = Integer.parseInt(stdin.readLine().trim());
                 //int searchIndex = Integer.parseInt(inputInfo);
                 System.out.print("Integer at the given index is " + list1.searchElement(searchIndex) + "\n");
                 break;
               case 'L':   //List integers
                 System.out.print(list1.toString());
                 break;
               case 'O':  // List Current Size
                 System.out.print("The current size is " + list1.size() + "\n");
                 break;
               case 'T':   //Reverse
                 list1.reverse();
                 System.out.print("list reversed\n");
                 break;
               case 'R':   //Remove Last few --
                 System.out.print("How many to remove:\n");
                 inputInteger = Integer.parseInt(stdin.readLine().trim());
                 list1.removeLastFew(inputInteger);
                 System.out.print("Removed " + inputInteger + " elements from the list\n");
                 break;
               case '?':   //Display Menu
                 printMenu();
                 break;
               case 'Q':   //Quit
                 break;
               default:
                 System.out.print("Unknown action\n");
                 break;
              }
           }
          else
           {
             System.out.print("Unknown action\n");
            }
          } while (input1 != 'Q' || line.length() != 1);
        }
       catch (IOException exception)
        {
          System.out.print("IO Exception\n");
        }
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu()
     {
       System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd an Integer\n" +
                        "E\t\tSearch for an Integer\n" +
                        "L\t\tList Integers\n" +
                        "R\t\tRemove Last Few\n" +
                        "T\t\tReverse\n" +
                        "O\t\tList Current Size\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
    } //end of printMenu()
}
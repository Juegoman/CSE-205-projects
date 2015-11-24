// Assignment #: 10
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: A class which implements the some of the capabilities of a 
//               standard linked list
//				NOTE: I wrote lines 82 - 265, everything else was given


/*   A linked list is a sequence of nodes with efficient
 element insertion and removal. This class
 contains a subset of the methods of the standard
 java.util.LinkedList class.
 */
import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {

        public Object data;
        public Node next;
    }
    //instance variable first points to the beginning of the linked list
    private Node first;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {

        first = null;

    }

    /**
     * @return the first element in the linked list
     */
    public Object getFirst() {

        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;

    }

    /**
     * @return the removed element
     */
    public Object removeFirst() {

        if (first == null) {
            throw new NoSuchElementException();
        }
        Object element = first.data;
        first = first.next;
        return element;

    }

    /**
     * Adds an element to the front of the linked list.
     *
     * @param element the element to add
     */
    public void addFirst(Object element) {

        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        //change the first reference to the new node
        first = newNode;

    }

    // add your methods here
    /**
     * **************************************************************************
     */
    
    //toString method
    @Override
    public String toString() {

        //inital bracket and set up the ListIterator
        String res = "{ ";
        ListIterator iter = listIterator();

        //while the list still has nodes
        while (iter.hasNext()) {

            //append the data to the string
            res = res + iter.next() + " ";

        }

        //append the end bracket and a newline and return
        return res + "}\n";

    }

    //returns the size of the list
    public int size() {
        
        //variables and set up the ListIterator
        int count = 0;
        ListIterator iter = listIterator();

        //while the list still has nodes
        while (iter.hasNext()) {

            //increment count and move to the next node
            count++;
            iter.next();

        }

        //return count
        return count;

    }

    //checks if size is zero
    public boolean isEmpty() {

        return size() == 0;

    }
    
    //returns the object at the sepecified index in the list
    public Object searchElement(int index) {

        //if the list is empty or the index is invalid return null
        if (isEmpty() || index < 0) {
            return null;
        } else {

            //setup
            int currInd = 0;
            ListIterator iter = listIterator();

            //while the current index is not above the target index
            while (!(currInd > index)) {

                //make sure that the list still has values
                if (iter.hasNext()) {
                    //if the current and target index match
                    if (currInd == index) {
                        //return the element
                        return iter.next();
                    } else {
                        //continue to traverse
                        iter.next();
                        currInd++;

                    }

                } else {
                    //if list ends before index reached
                    currInd = index + 1;
                }

            }
            //if list ends before index reached
            return null;
        }
    }
    
    //add the object at the specified index in the list
    public void addElement(int index, Object element) {
        //if index is out of bounds
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else {
            //setup
            int currInd = 0;
            ListIterator iter = listIterator();

            //while the current index is not above the target index
            while (!(currInd > index)) {
                //make sure that the list still has values or that the index is
                //the first index
                if (iter.hasNext() || currInd == index) {

                    //if target is reached
                    if (currInd == index) {

                        //add the element with the iterator and exit the loop
                        iter.add(element);
                        currInd = index + 1;

                    } else {
                        //continue traversing
                        iter.next();
                        currInd++;

                    }

                }

            }

        }

    }
    //reverse the order of elements in the array
    public void reverse() {

        //make a temporary array
        Object[] temp = new Object[size()];
        int j = 0;

        //copy the list into the array backwards
        for (int i = size() - 1; i > -1; i--) {
            temp[j] = searchElement(i);
            j++;
        }

        //clear the list and copy the array into the list
        first = null;
        ListIterator iter = listIterator();
        for (int i = 0; i < temp.length; i++) {

            iter.add(temp[i]);

        }

    }

    //remove elements from the end of the array
    public void removeLastFew(int howMany) {
        
        //if the parameter is less than 0 do nothing, if the parameter is 
        //greater than or equal to the size of the list clear it
        if (howMany < 0); else if (howMany >= size()) {
            first = null;
        } else {
            
            //set a stopping point for the iterator
            int tgt = (size() - howMany) + 1;
            
            //define, do not instantiate
            ListIterator iter;
            
            //loop for removal
            for (int i = 0; i < howMany; i++) {
            
                //create a new iterator at the beginning
                iter = listIterator();

                //traverse to stopping point in the list
                for (int j = 0; j < tgt; j++) {

                    iter.next();

                }

                //once at stopping point, remove the node.
                iter.remove();
                
                //repeat with a new iterator until howMany is fulfilled
            }
        }
    }

    /**
     * Returns an iterator for iterating through this list.
     *
     * @return an iterator for iterating through this list
     */
    public ListIterator listIterator() {

        return new LinkedListIterator();

    }

    private class LinkedListIterator implements ListIterator {

        private Node position;
        private Node previous;

        /**
         * Constructs an iterator that points to the front of the linked list.
         */
        public LinkedListIterator() {

            position = null;
            previous = null;

        }

        /**
         * Moves the iterator past the next element.
         *
         * @return the traversed element
         */
        @Override
        public Object next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = position; // Remember for remove

            if (position == null) {
                position = first;
            } else {
                position = position.next;
            }

            return position.data;

        }

        /**
         * Tests if there is an element after the iterator position.
         *
         * @return true if there is an element after the iterator position
         */
        @Override
        public boolean hasNext() {

            if (position == null) {
                return first != null;
            } else {
                return position.next != null;
            }

        }

        /**
         * Adds an element before the iterator position and moves the iterator
         * past the inserted element.
         *
         * @param element the element to add
         */
        @Override
        public void add(Object element) {

            if (position == null) {
                addFirst(element);
                position = first;
            } else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            previous = position;

        }

        /**
         * Removes the last traversed element. This method may only be called
         * after a call to the next() method.
         */
        @Override
        public void remove() {

            if (previous == position) {
                throw new IllegalStateException();
            }

            if (position == first) {
                removeFirst();
            } else {
                previous.next = position.next;
            }
            position = previous;

        }

        /**
         * Sets the last traversed element to a different value.
         *
         * @param element the element to set
         */
        @Override
        public void set(Object element) {

            if (position == null) {
                throw new NoSuchElementException();
            }
            position.data = element;

        }
    }//end of LinkedList iterator class
}//end of Linked List class


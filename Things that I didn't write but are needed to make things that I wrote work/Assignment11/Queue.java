// Assignment #: 11
//         Name: 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: Queue class uses the circular method for resizing and storing
//               data


public class Queue
{
	// instance variables
    private Object[] myData;
    private int mySize;
    private int myIndex;

	// Constructor
	public Queue()
	{	// initialize variables
		myData = new Object[10];
		mySize = 0;
		myIndex = 0;
	}

	// Method enqueue takes an Object and adds it to the end of the queue
	public void enqueue(Object value)
	{
		if(myData.length == mySize) // double array size if full
			doubleMyData();

		// Add new object to the end of the queue and update size
		if(mySize == 0)
			myData[myIndex] = value;
		else
			myData[(myIndex + mySize) % myData.length] = value; // % makes it wrap around
		mySize++;
	}

	// Method dequeue returns the Object at the front of the queue
	public Object dequeue()
	{
		Object result = myData[myIndex]; // store result
		myData[myIndex] = null; // null the spot dequeued from
		myIndex = (myIndex + 1) % myData.length; // update index
		mySize--; // update size

		return result;
	}

	// method length returns the number of elements in the queueu
	public int getSize()
	{
		return mySize;
	}

	// isEmpty returns boolean true if empty false if not.
	public boolean isEmpty()
	{
		return (mySize == 0);
	}

	public int capacity()
	{
		return myData.length;
	}

	// returns a String that has the values of the ArrayQueue in the order they were enqueued
        @Override
	public String toString()
	{
		String result = "";

		int j = myIndex;
		for(int i = 0; i < mySize - 1 ; i ++)
		{
			result += myData[j] + ", ";

			if(j == myData.length - 1)
				j = 0;
			else
				j ++;
		}

		result += myData[j];

		return result;
	}

	// prints out the elements of the array in the order they appear in the array,
	// skipping over spots that are null
	public void printArray()
	{
		System.out.println("The array printed out in physical order: ");

		for(int i = 0; i < myData.length - 1; i ++)
		{
			if(myData[i] != null)
				System.out.print(myData[i] + ", ");
		}

		System.out.println(myData[myData.length - 1]);
	}

	// helper method that doubles the queues size
	private void doubleMyData()
	{
		Object[] tmp = new Object[mySize * 2];

		for(int i = 0; i < mySize; i++)
		{
			tmp[i] = myData[i];
		}
		myData = tmp;
	}
}

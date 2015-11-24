// Assignment #: 11
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: An implementation of the Sieve of Eratosthenes algorithm using
//               queues.


public class Sieve {
    
    //instance vars
    private Queue nums, primes;
    
    //constructor
    public Sieve() {
        
        nums = new Queue();
        primes = new Queue();
        
    }
    
    // computes all primes up to some n and stores them internally in the queue
    public void computeTo(int n) {
        
        nums = new Queue();
        primes = new Queue();
        
        int lastPrime;
        
        for(int i = 2; i < n + 1; i++) {
            
            nums.enqueue(i);
            
        }
        
        if(!nums.isEmpty()) {
            do {

                lastPrime = (int) nums.dequeue();

                primes.enqueue(lastPrime);

                removeDivis(lastPrime);

            }while(lastPrime < Math.sqrt(n));
            
            while(!nums.isEmpty()) {
            
                primes.enqueue(nums.dequeue());
            
            }
        }
    }
    
    //writes all the primes to System.out (12 per line) from the queue
    public void reportResults() {
        
        int e = primes.getSize();
        int n;
        
        for(int i = 0; i < e; i++) {
        
            if(i != 0 && i % 12 == 0) System.out.print("\n");
            n = (int) primes.dequeue();
            System.out.print(n + " ");
            primes.enqueue(n);
        
        }
        
    }
    
    //returns the maximum prime found in the last call to computeTo
    public int getMax() {
        
        int e = primes.getSize();
        int n = 1;
        
        for(int i = 0; i < e; i++) {
            
            n = (int) primes.dequeue();
            primes.enqueue(n);
            
        }
        
        return n;
        
    }
    
    //returns the count of primes found in your queue
    public int getCount() {
        
        return primes.getSize();
        
    }
    
    //removes integers within a queue that are divisible with the parameter
    private void removeDivis(int num) {
        
        Queue temp = new Queue();
        int tempInt;
        
        while(!nums.isEmpty()) {
            
            tempInt = (int) nums.dequeue();
            if(tempInt % num != 0) {
                
                temp.enqueue(tempInt);
                
            }
            
        }
        nums = temp;
        
    }
    
}
//Kristina Saha UNI ks3401//
// Data Structures , Programming Problem 2//
// the comments for this code was already given in the MyQueue.java file 

import java.util.Stack;

public class TwoStackQueue {
	private Stack<Integer> S1 ;
    private Stack<Integer> S2 ;
      
    public TwoStackQueue() {
    	this.S1 = new Stack<Integer>();
    	this.S2 = new Stack<Integer>();
    }
    
    // Performs the enqueue operation
    public void enqueue(Integer value) {
    	System.out.println("Enqueue " + value);
        exchange(S1, S2);
       S1.push(value);
} 	

    private void exchange(Stack<Integer> Stack1, Stack<Integer> Stack2) {
		// TODO Auto-generated method stub
    	while (!Stack2.empty())
    		Stack1.push(Stack2.pop());
	}

	// Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public Integer dequeue(){
    	int value;
    	
    	exchange(S2, S1);
    	value = S2.pop();
    	System.out.println("Dequeue" + value);
    	return value;
    }
    
    // Checks if the Queue is empty
    public boolean isEmpty() {
    	return S1.empty() && S2.empty();
    }
    	
    // Returns the number of elements currently in the queue
    public int size() {
    	return S1.size() + S2.size() ; 
    }
}
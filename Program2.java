//Kristina Saha UNI ks3401//
// Data Structures , Programming Problem 2//
public class Program2 {

	public static void main (String[] args){
		TwoStackQueue numbers = new TwoStackQueue();

       numbers.enqueue(4);
       numbers.enqueue(10);
       numbers.enqueue(5);
       numbers.enqueue(8);
       numbers.dequeue();
       numbers.dequeue();
       numbers.enqueue(3);
       numbers.enqueue(88);

        while(!numbers.isEmpty())
            numbers.dequeue();
	}
}

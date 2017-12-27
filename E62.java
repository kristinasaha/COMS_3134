// ****************************************** 
// E62 program 
// written by Kristina Saha 
// Using java for number recognition 
// *******************************************

import java.util.Scanner; //inserting a new scanner for inputs
public class E62 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0 ; //the beginning sum is 0
	    for(int i = 0; i <= 100; i=i+2)  // adding by 2 makes numbers even and divisible by 2 
	    {
	      sum = sum + i ; //add the original sum (0) by all of the multiples of 2 between 0 and 100
	        	
	        }
System.out.println(sum); // prints out the sum of all the even numbers

	    
	int sum2 = 0; // new variable sum2 for the new sum
		for (int x = 1; x <= 100; x++ ) //all values between 1 and 100 including 1 and 100
		{
		  sum2 += x*x; // taking the sum of all the squares and adding it to original sum 0 
	   }
System.out.println(sum2); // prints out the sum of all the squares between/including 1 and 100
	
	int sum3 = 0 ;  // reset sum for new variable
		for (int y = 0; y <=20; y++) // for all the values of exponent y from 0-20
		{
			sum3 += Math.pow(2, y); //with a base of 2 and an exponent of y from 0-20, add all of the numbers
		}
		System.out.println(sum3); //print the sum!!
		
		
		Scanner in = new Scanner(System.in); //entered a new scanner for inputs
		
		//Enter values for a and b 
		int a = in.nextInt();  
		int b = in.nextInt();
		int sum4 = 0; //the sum is currently 0

	       for (int z = a; z <= b; z++) //all odd values between inputs
	       {
	           if (z % 2 == 1) //determining if odd value
	             sum4 += z;  //adding all odd numbers between inputs
	       }
	       System.out.println(sum4); 
	       
	     int value = in.nextInt(); //new inputs (must be odd)
	     int sum5= 0; //resetting the sum to be 0 
	     int digit=0; //digits as in the specific digits of the input

	     while ( value > 0 )
	     {
	         digit=value % 10; // looks at the last digit every time it loops
	         if ( digit %2 == 1 ) // determines if it is odd
	         {
	             sum5+=digit; // finds the sum of the odd digits in the input
	         }
	         value/=10;
	     }
	     	System.out.println(sum5);
	     
	}}




	    



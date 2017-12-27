/* ********************************
 Kristina Saha   (UNI ks3401)    
 programming project 1          
******************************* */

public class Problem3 {
	public static void main(String[] args) {
		int [] nArray = new int[5];
		for (int i=0; i < nArray.length ; i++){  //creating an array of n values
		nArray[i] = (int)Math.pow(5,i);
		}
		
		for (int i= 0; i < nArray.length ; i++) { 
			getTime1(nArray[i]);   //calling the array so that they will return the time that it took for each method
			getTime2(nArray[i]);
			getTime3(nArray[i]);	
		}
		
	}	
		
	public static int getTime1(int n) {   //for the first fragment
		int starTime = (int) System.nanoTime();
		int sum = 0;
		for (int i = 0; i < 23; i++)
			for (int j = 0; j < n; j++)
				sum = sum + 1;
		int endTime = (int) System.nanoTime();
		System.out.println("The"+ " " + (n) + " " + "value runs for"+ " " + (endTime - starTime) + " " + "nanoseconds");
		return endTime - starTime;

	}

	public static int getTime2(int n) {   //for the second fragment
		int starTime = (int) System.nanoTime();
		int sum = 0;
		for (int i = 0; i < n; i++)
			for (int k = i; k < n; k++)
				sum = sum + 1;
		int endTime = (int) System.nanoTime();
		System.out.println("The"+ " " + (n) + " " + "value runs for"+ " " + (endTime - starTime) + " " + "nanoseconds");
		return endTime - starTime;
	}

	public static int foo(int n, int k) { //for the third fragment
		if (n <= k)
			return 1;
		else
			return foo(n / k, k) + 1;
	}
	
	public static int getTime3(int n){ //for the third fragment because it already had a method.
	int starTime = (int) System.nanoTime(); //this helps for that fragment to be called and hav the same formatting as the other fragments.
	int fooResult = foo(n,2);
	int endTime = (int) System.nanoTime();
	System.out.println("The"+ " " + (n) + " "+ "value runs for"+ " " + (endTime - starTime) + " " + "nanoseconds");
	return endTime - starTime;
	}
}


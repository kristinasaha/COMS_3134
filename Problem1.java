/* ********************************
 Kristina Saha   (UNI ks3401)    
 programming project 1          
******************************* */

public class Problem1 {
	
	public static <AnyType extends Comparable<AnyType>>  AnyType findMax(AnyType[] arr) {
		  int maxIndex = 0;
		  for (int i = 1; i < arr.length; i++)
		    if ( arr[i].compareTo(arr[maxIndex]) > 0 )
		       maxIndex = i;
		  return arr[maxIndex];
		 // return maxIndex;
		}
	  
	
	public static void main(String[] args) {   // an array of rectangles with their lengths and widths.
	
		Rectangle[] rectangles;
		rectangles = new Rectangle[6];
		rectangles[0] = new Rectangle(1,3);
		rectangles[1] = new Rectangle(2,5);
		rectangles[2] = new Rectangle(5,6);
		rectangles[3] = new Rectangle(3,4);
		rectangles[4] = new Rectangle(7,8);
		rectangles[5] = new Rectangle(8,2);
		
	System.out.println(findMax(rectangles)); //will print the largest length and width
	
	
		
		
		
	

	
		
	}	    
		
}

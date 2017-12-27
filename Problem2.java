/* ********************************
 Kristina Saha   (UNI ks3401)    
 programming project 1          
******************************* */

import java.util.Arrays;

public class Problem2 {
	
	private static int start;
	private static int end;
	
	public static <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x){
		int mid = (start + end) / 2; //3
        
        //base case
        if (x.compareTo(a[mid]) == 0)    //base case is midpoint
            return mid;
        
        //recursive 
        while (start <= end) {
            if (x.compareTo(a[mid]) < 0) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
            return binarySearch(a,x); //recursive call
        }
        return -1;
    }
	
	private static int Rectangle(int i, int j) { 
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void changeStart(int newStart) 
	{
		start = newStart;
	}
	
	public static void changeEnd(int newEnd)
	{
		end = newEnd;
	}

	public static void main(String[] args) { //array of rectangles with lenght and width
		
		Rectangle[] rectangles;
		rectangles = new Rectangle[6];
		rectangles[0] = new Rectangle(1,3);
		rectangles[1] = new Rectangle(2,5);
		rectangles[2] = new Rectangle(5,6);
		rectangles[3] = new Rectangle(3,4);
		rectangles[4] = new Rectangle(7,8);
		rectangles[5] = new Rectangle(8,2);
	
		Arrays.sort(rectangles);  //sorts the rectangles from smallest to largest
		System.out.println("Sorted String Array");
		for (Rectangle str : rectangles) {
			System.out.println(str); //prints the sorted array
		}
		
		changeStart(0); //resets Start to 0
		changeEnd(rectangles.length-1); //resets end to the array list length - 1
		System.out.println(binarySearch(rectangles,new Rectangle(7,8))); // prints the index of hte rectangle with the lenght of 7 and width of 8
		
}
}

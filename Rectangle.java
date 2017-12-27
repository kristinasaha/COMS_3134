/* ********************************
 Kristina Saha   (UNI ks3401)    
 programming project 1          
******************************* */

public class Rectangle implements Comparable<Rectangle> {
	private int length;  //the different variables of a rectangle that will be dealt with
	private int width;
	private int perimeter;
	
	Rectangle(int l, int w) {  // basic information about what is length and width, how they will show in the array, and how to find perimeter
			length = l;
			width = w;
			perimeter = 2*length + 2*width;
		}
	
	public int getLength() { //will return the length
		return length;
	}
	
	public int getWidth(){ // will return the width
		return width;
	}
	
	public int getPerimeter(){  //will return the perimeter
		return perimeter;
	}
	
	@Override
	public String toString() { //Object //Rectangle class inherits the Object class's toString()
		return "" + length + " " + width ; 
		
	}
	
		@Override
		public int compareTo(Rectangle o) {   //returns certain values after rectangles are compared to each other  
			if (this.getPerimeter() == o.getPerimeter()){
				return 0;	
			}
			else if (this.getPerimeter() < o.getPerimeter()){
				return -1;	 
			}
			else if (this.getPerimeter() > o.getPerimeter()){
				return 1;
			}
			return 0;
			
		}
		
				
}


// ****************************************** 
// P71 Class
// written by Kristina Saha 
// *******************************************

import java.util.Random;

public class P71 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Die a = new Die ();
		int[] myValues = a.getValues();
	
		//setting inRun equal to False
		 boolean inRun = false;
		 int prevNum = myValues[0];
	
//If statements for booleans. Compares the digits in the array.
		 for (int i = 0; i < myValues.length-1; i++)
		 { 
	          if (inRun) 
	          { 
				if (myValues[i] != prevNum ) 
				{ 
	                System.out.print(")"); 
	                inRun = false; 
	            }
	          }
	          else 
	          {
	            if (myValues [i] == myValues[i+1])
	            {
	                System.out.print("(");
	                inRun = true;
	            }
	          }
	          
	         //Resets prevNum for each iteration
	          prevNum = myValues[i];
	          System.out.print(myValues[i]);
	     }
	}
}



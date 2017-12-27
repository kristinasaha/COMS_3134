// ****************************************** 
// P72 Class 
// written by Kristina Saha 
// *******************************************
public class P72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Die a = new Die ();
		int[] myValues = a.getValues();
		 boolean inRun = false;
	//Variables 
		 int prevNum = myValues[0];
		 int longestRun = 0; 
		 int currentLength = 1;
		 int whatIsLongestRun = -1;
		 int whatIsCurrRun = -1;  
		 
	//If statements comparing numbers in the array
		 for (int i = 0; i < myValues.length-1; i++)
		 { 
	          if (inRun) 
	          { 
				if (myValues[i] != prevNum ) 
				{ 
	                
	                inRun = false; 
	                currentLength=1;  //resets currentLength
	            }
				else //myVal[i] == prevNum
					currentLength++;   //looks onto the next number
	          }
	          else //inRun is false, but checking if new run is starting
	          {
	            if (myValues [i] == myValues[i+1])
	            {
	                inRun = true;
	                whatIsCurrRun = myValues[i];
	            }
	          }
	          
	          //compares the longest runs
	          prevNum = myValues[i];
//sees which value is bigger, currentlength or longestRun 
	          longestRun = Math.max(currentLength, longestRun);
	          if(longestRun==currentLength) 
// if they are the same, the longest run becomes the current run
	        	  whatIsLongestRun = whatIsCurrRun;
	          System.out.print(myValues[i]);
	     }
		 System.out.println();
		 for(int i=0; i<longestRun; i++)
		 {
			 System.out.print(whatIsCurrRun);
		 }
	}
}



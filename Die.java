// ****************************************** 
// Die Class
// written by Kristina Saha 
// *******************************************

import java.util.Random;

public class Die {        
	private int i; 
	private int[] values = new int[20];

public Die(){
	i=6;         
	roll();     
	}

public void roll() {
	for (int j=0; j < 20; j++){
		int side = (int) (Math.random() * i +1);
		values[j] = side;
	}
}

public int[] getValues() { 
	return values;     }
}

	

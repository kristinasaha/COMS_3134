// ****************************************** 
// Car program 
// written by Kristina Saha 
// 
// Prints how much gas is left after filling the gas tank
// and driving for a certain distance.
// *******************************************

public class Car {
	private double mpg; //miles per gallon
	private double gas;
	public Car(double MilesPerGallon){
		mpg = MilesPerGallon;
	}
	
	//The car drives a certain distance and uses up gas
	public void drive (double distance)
	{
	    gas = gas - (distance / mpg);
	}

	
 //how much gas is left
	public double getGas()
	{
	    return gas;
	}
	
	public void addGas (double gasLeft){
		gas = gas + gasLeft;
	}
}

// ****************************************** 
// CarTester program 
// written by Kristina Saha 
// Outline for how much gas will remain after 
// a car drives a certain amount of time.
// *******************************************

public class CarTester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Car myHybrid = new Car(50);
	System.out.println(myHybrid.getGas());
	
	myHybrid.addGas(20);
	System.out.println(myHybrid.getGas());
	
	myHybrid.drive(100);
	System.out.println(myHybrid.getGas());
	
	double gasLeft = myHybrid.getGas();	
	System.out.println(myHybrid.getGas());


	



	}

}

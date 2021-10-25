package Inheritance2;

public class Benz extends Car {

	int transmission;
	public Benz() {
		//why super should be the first statement? Because parent constructor is called first
		this.transmission = 4;
		
		// TODO Auto-generated constructor stub
		System.out.println("Benz ka constructor");
	}
	
	
}

package Inheritance2;

import Inheritance.IronManV1;

public class IronManV3 extends IronManV1 {

	public static void main(String[] args) {
		IronManV3 v3 = new IronManV3();
		 //default are accessible only in same package
		//v3.helmet; //protected hai wo accessible hai differnet package child class
	}
}

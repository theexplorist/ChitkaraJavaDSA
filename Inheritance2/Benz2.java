package Inheritance2;

public class Benz2 extends Benz {

	public Benz2() {
		// TODO Auto-generated constructor stub
		System.out.println("Benz 2 ke ka constructor");
	}
	
	public static void main(String[] args) {
		Benz2 b = new Benz2();
		System.out.println(b.companyName);
	}
}

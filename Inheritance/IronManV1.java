package Inheritance;

public class IronManV1 {

	int helmet = 1;
	int legs = 2;
	int hands = 2;
	String arcReactor = "palladium";

	public void canFly() {
		// TODO Auto-generated method stub
		System.out.println("Main ud ni sakta!");
	}
	
	final public void missiles() { //inherited but cannot be overrided
		// TODO Auto-generated method stub

	}
	private void flameThrower() { //inheritance not allowed
		// TODO Auto-generated method stub

		System.out.println("Main aag barsata hun!");
	}
}

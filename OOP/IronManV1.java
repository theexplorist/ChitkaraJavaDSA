package OOP;

//noun - class name
public class IronManV1 {

	
	//adjectives - characteristics/variables - object/instance variables
	private int helmet = 1;
	String arcReactor = "palladium";
	int legs = 2;
	int hands = 2;
	String ai;
	//verb - kriya/kya kar sakta hai - function/methods
	
	public void setAi() {
		String ai = "jarvis"; //local > object variable
		this.ai = "jarvis"; //object variable
	}
	public void canFly() {
		// TODO Auto-generated method stub
		//IronManV1 v = new IronManV1();
		System.out.println("Main ud sakta hun!");
	}
	
	private void canSwim() {
		// TODO Auto-generated method stub

	}
	
	private void canShootMissile() {
		// TODO Auto-generated method stub

	}
}

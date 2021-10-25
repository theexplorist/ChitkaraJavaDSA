package Inheritance;

public class IronManV2 extends IronManV1 {

	String ai = "Jarvis";
	
	//Bhagban -> sirf apne ko better krne ke liye
	@Override //parent ki implementation hide krna
	public void canFly() {
		// TODO Auto-generated method stub
		System.out.println("Main ud sakta hun!");
		
		
	}

	public void unibeam() {
		// TODO Auto-generated method stub
		super.canFly(); //v1.canFly
		System.out.println("Main unibeam fenkta hun!");
	}
	
}

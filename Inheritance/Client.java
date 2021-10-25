package Inheritance;

public class Client {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Ref -> Child Class, Obj -> Child Class
		IronManV2 im = new IronManV2();
		im.canFly();
		im.unibeam();
		
		//Ref -> Parent Class, Obj -> Parent Class
		IronManV1 im1 = new IronManV1();
		im1.canFly();
	
		
		//Ref -> Parent, Obj -> Child
		IronManV1 suit = new IronManV2();
		suit.canFly(); //hamesha override wala hi call hoga agar override ni hai to parent ka call
	
		suit.missiles();
		
		//suit.unibeam();//compiler ke liye lhs is v1, or v1 mein unibeam hai hi ni
		
	}

}

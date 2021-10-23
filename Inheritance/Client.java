package Inheritance;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IronManV2 im = new IronManV2();
		im.canFly();
		im.unibeam();
		IronManV1 im1 = new IronManV1();
		im1.canFly();
		
	}

}

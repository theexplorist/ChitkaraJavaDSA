package OOP;

public class IronManClient {
	public static void main(String[] args) {
		/*
		IronManV1 im1 = new IronManV1();

		// new IronManV1();//anonymous object
		System.out.println(im1);
		System.out.println(im1.arcReactor);// dot operator //get
		im1.canFly();

		im1.arcReactor = "vibranium"; // dot operator //set
		System.out.println(im1.arcReactor);
		System.out.println(im1.ai);
		im1.setAi();//this = 2k pass ho gya
		System.out.println(im1.ai);
		// System.out.println(im1.a);
		 */
		
		IronManV1 im1 = new IronManV1();
		IronManV1 im2 = new IronManV1();
		
		im1.arcReactor = "vibranium";
		
		System.out.println(im1.arcReactor);//vib
		System.out.println(im2.arcReactor);//pall
	}

}

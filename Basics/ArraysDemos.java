package Basics;
import OOP.IronManV1;

public class ArraysDemos {

	private static void colorChange(char[] yashbeerHouse, int ci) {
		// TODO Auto-generated method stub

		if(ci == yashbeerHouse.length) {
			return;
		}
		yashbeerHouse[ci] = 'G'; //
		colorChange(yashbeerHouse, ci + 1);
		yashbeerHouse[ci] = 'B';//
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		int[] kartik = new int[5];
//		System.out.println(kartik);
		
		char[] yashbeerHouse = {'B', 'B', 'B'};
		colorChange(yashbeerHouse, 0);
		
		for(char color : yashbeerHouse) {
			System.out.print(color + " ");
		}
		
		IronManV1 im1 = new IronManV1();
	}

}

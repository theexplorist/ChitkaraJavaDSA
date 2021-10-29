package StackQps2;

public class TwoDArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[5];
		//System.out.println(arr);
		int r = 5;
		int c = 6;
		int[][] twoD = new int[r][c];
		System.out.println(twoD);
		
		System.out.println(twoD[0]);//1d array ka address
		System.out.println(twoD[0].length); //number of cols in a rectangular matrix
		System.out.println(twoD.length);//no of rows
	}

}

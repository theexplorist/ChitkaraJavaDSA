package StackQps2;

public class JaggedArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] jagged = new int[5][];
		jagged[0] = new int[3];
		jagged[1] = new int[4];
		jagged[2] = new int[2];
		jagged[3] = new int[1];
		jagged[4] = new int[5];
		
		for(int r = 0; r < jagged.length; r++) {
			for(int c = 0; c < jagged[r].length; c++) {
				System.out.println(jagged[r][c]);
			}
		} 
	}

}

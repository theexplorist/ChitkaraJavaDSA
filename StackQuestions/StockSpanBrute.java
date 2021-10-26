package StackQuestions;

import java.util.Arrays;

public class StockSpanBrute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ht = {1, 2, 4, 3, 5};
		
		int[] span = new int[ht.length];
		
		Arrays.fill(span, 1);//hr index pr 1 rakh dia
		
		for(int buiInd = 1; buiInd < ht.length; buiInd++) {
			
			for(int preBuild = buiInd - 1; preBuild >= 0; preBuild--) {
				if(ht[preBuild] < ht[buiInd]) {
					span[buiInd]++;
				} else {
					break;
				}
			}
		}
		
		for(int sp : span) {
			System.out.print(sp + " ");
		}
	}

}

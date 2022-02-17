package SegmentTree;

public class SegmentTree {

	private static void buildTree(int[] arr, int[] segT, int l,  int r, int ci) {
		// TODO Auto-generated method stub

		if(l == r) {
			segT[ci] = arr[l];
			return;
		}
		int mid = (l + r) / 2;
		buildTree(arr, segT, l, mid, 2 * ci);
		buildTree(arr, segT, mid + 1, r, 2 * ci + 1);
		
		segT[ci] = segT[2 * ci] + segT[2 * ci + 1];
	}
	
	private static int rangeSumQuery(int[] segT, int ql, int qr, int cl, int cr, int ci) {
		// TODO Auto-generated method stub

		//no overlap
		if(cr < ql || cl > qr) {
			return 0;
		}
		
		if(cl >= ql && cr <= qr) {
			
			return segT[ci];
		}
		
		int mid = (cl + cr) / 2;
		int leftSum = rangeSumQuery(segT, ql, qr, cl, mid, 2 * ci);
		int rightSum = rangeSumQuery(segT, ql, qr, mid + 1, cr, 2 * ci + 1);
		
		return leftSum + rightSum;
	}
	
	private static void pointUpdate(int[] segT, int upI, int l, int r, int val, int ci) {
		// TODO Auto-generated method stub

		if(l == r) {
			segT[ci] = val;
			return;
		}
		int mid = (l + r) / 2;
		if(upI <= mid) {
			pointUpdate(segT, upI, l, mid, val, 2 * ci);
		} else {
			pointUpdate(segT, upI, mid + 1, r, val, 2 * ci + 1);
		}
		
		segT[ci] = segT[2 * ci] + segT[2 * ci + 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
		
		int[] segT = new int[4 * arr.length];
		buildTree(arr, segT, 0, arr.length - 1, 1);
		//System.out.println(Arrays.toString(segT));
		System.out.println(rangeSumQuery(segT, 0, 1, 0, arr.length - 1, 1));
		int upI = 2;
		int val = 50;
		//arr[upI] = val;
		
		pointUpdate(segT, upI, 0, arr.length - 1, val, 1);
		System.out.println(rangeSumQuery(segT, 2, 5, 0, arr.length - 1, 1));
	}

}

package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

	class MedianFinder {

	    PriorityQueue<Integer> min;
	    PriorityQueue<Integer> max;
	    public MedianFinder() {
	        min = new PriorityQueue<>();
	        max = new PriorityQueue<>(Collections.reverseOrder());
	    }
	    
	    public void addNum(int num) {
	        if(max.isEmpty() || max.peek() >= num) {
	            max.add(num);
	        } else {
	            min.add(num);
	        }
	        
	        balanceHeap();
	    }
	    
	    public double findMedian() {
	        
	        //even
	        if(max.size() == min.size()) {
	            return ((double)max.peek() + min.peek()) / 2;
	         } else { //odd max = min + 1
	            return max.peek();
	        }
	    }
	    
	    public void balanceHeap() {
	        
	        if(max.size() > min.size() + 1) {
	            min.add(max.poll());
	        } else if(min.size() > max.size()) {
	            max.add(min.poll());
	        }
	    }
	}
}

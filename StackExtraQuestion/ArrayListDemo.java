package StackExtraQuestion;

import java.util.ArrayList;
import java.util.Stack;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Stack<Integer>> stackList = new ArrayList<>(); 
		//add at last
		list.add(10);//0
		list.add(20);//1
		list.add(30);//2
		System.out.println(list);
		System.out.println(list.get(1));//get at index
		System.out.println(list.size());
		
		System.out.println(list.remove(0));
		System.out.println(list);
		
		//last element remove
		list.remove(list.size() - 1);
	}

}

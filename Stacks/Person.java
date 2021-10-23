package Stacks;

public class Person {

	String fullName;//null
	
	public Person() {
		// TODO Auto-generated constructor stub
		fullName = "kartik";
	}
	public Person(String fullName) {
	   // fullName = fullName //local = local
		this.fullName = fullName;//class variable = local var
	}
	
	public static void main(String[] args) {
		Person p = new Person("James Bond");
		System.out.println(p.fullName);
	}
}

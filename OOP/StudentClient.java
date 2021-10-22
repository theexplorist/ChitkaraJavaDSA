package OOP;

public class StudentClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1.uniform);//do not access static vars like object vars
		System.out.println(s2.uniform);
		
		//s1.uniform = "blue";
		//className.variableName
		Student.uniform = "blue";
		
		System.out.println(s1.uniform);
		System.out.println(s2.uniform);
	}

}

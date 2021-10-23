package ExceptionHandlingg;

import java.util.Scanner;

public class MultipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		try {
			
			int a = 5/2;
			System.out.println(a);
			return;
//			int a  = 5/ 0; //1
//			int[] arr = new int[5];
//			arr[6] = 5; //2
//			String st  = "hello";
//			st.charAt(6); //3
		} catch (ArithmeticException e) {

			System.out.println("0 se divide mt kro!");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("Galat index of array");
		} catch (StringIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("Galat index of string");
		} catch(Exception e) {
			System.out.println("Exception ka sbse bada block");
		} finally {
			sc.close();
			System.out.println("Yo to chalega!");
		}
		
		System.out.println("hello bhai!");
	}

}

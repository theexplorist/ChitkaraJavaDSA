
public class ChangesInHeap {

	
	private static void change(char[] yashbeerHouse) {
		// TODO Auto-generated method stub

		for(int i = 0; i < yashbeerHouse.length; i++)
		yashbeerHouse[i] = 'G';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] yashbeerHouse = {'B', 'B', 'B'};
		System.out.println(yashbeerHouse[0]); //B
		change(yashbeerHouse);
		System.out.println(yashbeerHouse[0]); //
	}
}
